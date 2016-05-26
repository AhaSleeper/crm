package com.zhuojh.mapper.order;

import com.zhuojh.model.order.Order;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByPage(@Param("order") Order order, @Param("page") Pagination page);
}