package com.zhuojh.mapper.base;

/**
 * Created by Administrator on 2016/4/16.
 */
public class MySQLDialect extends Dialect{
    public boolean supportsLimitOffset(){
        return true;
    }

    public boolean supportsLimit(){
        return true;
    }

    public String getLimitString(String sql, int offset, int limit){
        return getLimitString(sql, offset, limit);
    }

    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder){
        if(offset > 0){
            return sql + " limit "+offsetPlaceholder+" ,"+limitPlaceholder;
        }else {
            return sql + " limit "+limitPlaceholder;
        }
    }
}


