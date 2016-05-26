package com.zhuojh.controller.order;

import com.zhuojh.model.order.Order;
import com.zhuojh.model.order.OrderDetails;
import com.zhuojh.service.order.OrderService;
import common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询客户订单列表
     * @param order
     * @param pageNo
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("/list")
    public String list(Order order, Integer pageNo, Integer pageSize, ModelMap modelMap){
        if(pageNo==null || pageNo==0) pageNo=1;
        if(pageSize==null || pageSize==0) pageSize = 10;
        Pagination page = orderService.list(order,pageNo,pageSize);
        modelMap.addAttribute("page",page);
        return "order/orders";
    }

    /**
     * 获取订单详情
     * @param orderId
     * @param modelMap
     * @return
     */
    @RequestMapping("/getOrderDetails")
    public String getOrderDetails(Integer orderId, ModelMap modelMap) {
        Order order = orderService.getOrderById(orderId);
        List<OrderDetails> list = orderService.getOrderDetails(orderId);
        modelMap.addAttribute("order", order);
        modelMap.addAttribute("orderDetails",list);
        return "order/orderDetails";
    }

}
