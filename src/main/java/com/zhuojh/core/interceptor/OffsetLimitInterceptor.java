package com.zhuojh.core.interceptor;

import com.zhuojh.mapper.base.Dialect;
import com.zhuojh.mapper.base.MySQLDialect;
import common.page.Pagination;
import javassist.tools.reflect.Metaobject;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/4/16.
 */
@Intercepts({@Signature(type= StatementHandler.class, method="prepare", args=Connection.class)})
public class OffsetLimitInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(OffsetLimitInterceptor.class);
    static int MAPPED_STATEMENT_INDEX = 0;
    static int PARAMETER_INDEX = 1;
    static int ROWBOUNDS_INDEX = 2;
    static int RESULT_HANDLER_INDEX = 3;
    Dialect dialect;
    private Properties properties;
    private String defaultPageSqlId = ".*Page$";

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    public OffsetLimitInterceptor(){this.properties = null;}

    private void getDialect() throws Exception{
        this.dialect = new MySQLDialect();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        getDialect();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,
                DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY);
        //分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
        //可以分离出最原始的目标类）
        while(metaStatementHandler.hasGetter("h")){
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
                    DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        //分离最后一个代理对象的目标类
        while(metaStatementHandler.hasGetter("target")){
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
                    DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");

        String pageSqlId = this.properties.getProperty("pageSqlId");
        if(null == pageSqlId || "".equals(pageSqlId)){
            log.warn("Property pageSqlId is not setted, user default '.*Page$' ");
            pageSqlId = defaultPageSqlId;
        }

        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        //只重写需要的分页的sql语句，通过MappedStatement的ID匹配，默认重写以Page结尾的
        //MappedStatement的sql
        if(mappedStatement.getId().matches(pageSqlId)){
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            if(parameterObject == null){
                throw new NullPointerException("parameterObject is null!");
            } else {
                //分页参数作为参数对象parameterObject的一个属性
                Pagination page = (Pagination) metaStatementHandler.getValue("delegate.boundSql.parameterObject.page");
                String sql = boundSql.getSql();
                //重写sql
                String pageSql = buildPageSql(sql,page);
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                //采用物理分页后，就不需要mybatis的内存分页了，所以要重置下面的两个参数
                metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
                Connection connection = (Connection) invocation.getArgs()[0];
                //重设分页参数里的总页数等
                setPageParameter(sql, connection, mappedStatement, boundSql, page);
            }
        }
        //将执行权交给下一个拦截器
        return invocation.proceed();
    }

    private String buildPageSql(String sql, Pagination page){
        if(page != null){
            StringBuilder pageSql = new StringBuilder();
            pageSql = buildPageSqlForMysql(sql, page);
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    public StringBuilder buildPageSqlForMysql(String sql, Pagination page){
        StringBuilder pageSql = new StringBuilder(100);
        String beginRow = String.valueOf((page.getPageNo() - 1) * page.getPageSize());
        pageSql.append(sql);
        pageSql.append(" limit " + beginRow + "," + page.getPageSize());
        return pageSql;
    }

    public StringBuilder buildPageSqlForOracle(String sql, Pagination page){
        StringBuilder pageSql = new StringBuilder(100);
        String beginRow = page.getFirstResult()+"";
        String endRow = String.valueOf(page.getPageNo() * page.getPageSize());
        pageSql.append("select * from ( select temp.*, rownum row_id from (");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endRow);
        pageSql.append(") where row_id > ").append(beginRow);
        return pageSql;
    }

    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
                                  Pagination page){
        //记录总记录数
        String countSql = "select count(0) from (" + sql + ") total";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if(rs.next()){
                totalCount = rs.getInt(1);
            }
            page.setTotalCount(totalCount);
        } catch (SQLException e) {
            log.error("Ignore this exception",e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("Ignore this exception",e);
            }
            try {
                countStmt.close();
            } catch (SQLException e) {
                log.error("Ignore this exception", e);
            }
        }
    }
    @Override
    public Object plugin(Object target) {
        if(target instanceof  StatementHandler){
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * 对SQL参数（？）设值
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }
}
