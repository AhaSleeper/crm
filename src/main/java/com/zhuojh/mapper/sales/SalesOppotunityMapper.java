package com.zhuojh.mapper.sales;

import com.zhuojh.model.sales.SalesOppotunity;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesOppotunityMapper {
    int deleteByPrimaryKey(String saleOppId);

    int insert(SalesOppotunity record);

    int insertSelective(SalesOppotunity record);

    SalesOppotunity selectByPrimaryKey(String saleOppId);

    int updateByPrimaryKeySelective(SalesOppotunity record);

    int updateByPrimaryKey(SalesOppotunity record);

    boolean deleteByIds(List<String> list);

    List<SalesOppotunity> selectByPage(@Param("salesOppotunity") SalesOppotunity salesOppotunity, @Param("page") Pagination page);

    List<SalesOppotunity> selectByAssignToPage(@Param("salesOppotunity") SalesOppotunity salesOppotunity,@Param("page") Pagination pagination);
}