package com.zhuojh.mapper.order;

import com.zhuojh.model.order.OrderDetails;

import java.util.List;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer orderDetailId);

    int updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);

    List<OrderDetails> selectByOrderId(Integer id);
}