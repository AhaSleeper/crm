package com.zhuojh.service.order;

import com.zhuojh.model.order.Order;
import com.zhuojh.model.order.OrderDetails;
import common.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface OrderService {
    Pagination list(Order order, Integer pageNo, Integer pageSize);
    Order getOrderById(Integer id);
    List<OrderDetails> getOrderDetails(Integer id);
}
