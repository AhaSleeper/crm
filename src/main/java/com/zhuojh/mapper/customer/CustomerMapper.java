package com.zhuojh.mapper.customer;

import com.zhuojh.model.customer.Customer;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(String customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    int deleteByIds(List<String> idList);

    List<Customer> selectByPage(@Param("customer") Customer customer, @Param("page") Pagination pagination);
}