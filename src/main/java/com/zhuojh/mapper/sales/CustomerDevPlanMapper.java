package com.zhuojh.mapper.sales;

import com.zhuojh.model.sales.CustomerDevPlan;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDevPlanMapper {
    int deleteByPrimaryKey(String customerDevPlanId);

    int insert(CustomerDevPlan record);

    int insertSelective(CustomerDevPlan record);

    CustomerDevPlan selectByPrimaryKey(String customerDevPlanId);

    int updateByPrimaryKeySelective(CustomerDevPlan record);

    int updateByPrimaryKey(CustomerDevPlan record);

    int deleteByIds(List<String> list);

    List<CustomerDevPlan> selectByPage(@Param("customerDevPlan") CustomerDevPlan customerDevPlan, @Param("page") Pagination page);

    List<CustomerDevPlan> selectByOppId(String salesOppId);
}