package com.zhuojh.service.order.impl;

import com.zhuojh.mapper.order.OrderDetailsMapper;
import com.zhuojh.mapper.order.OrderMapper;
import com.zhuojh.model.order.Order;
import com.zhuojh.model.order.OrderDetails;
import com.zhuojh.service.order.OrderService;
import common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    /**
     * 列表查询订单
     * @param order
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Pagination list(Order order, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<Order> list = orderMapper.selectByPage(order,page);
        page.setList(list);
        return page;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderDetails> getOrderDetails(Integer id) {
        return orderDetailsMapper.selectByOrderId(id);
    }
}
