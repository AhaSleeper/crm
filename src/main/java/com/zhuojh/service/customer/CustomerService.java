package com.zhuojh.service.customer;

import com.zhuojh.model.customer.Customer;
import common.page.Pagination;

/**
 * Created by Administrator on 2016/4/24.
 */
public interface CustomerService {
    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean deleteByIds(String ids);
    Pagination selectByPage(Customer customer, Integer pageNo, Integer pageSize);
}
