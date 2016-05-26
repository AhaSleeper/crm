package com.zhuojh.service.customer.impl;

import com.zhuojh.mapper.customer.CustomerMapper;
import com.zhuojh.model.customer.Customer;
import com.zhuojh.service.customer.CustomerService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/24.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean save(Customer customer) {
        customer.setCustomerId(GuidCreator.getUUID());
        return customerMapper.insert(customer) > 0;
    }

    @Override
    public boolean update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        List<String> idList = Arrays.asList(idArr);
        boolean flag = customerMapper.deleteByIds(idList) > 0;
        return flag;
    }

    @Override
    public Pagination selectByPage(Customer customer, Integer pageNo, Integer pageSize) {
        Pagination pagination = new Pagination();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        List<Customer> list = customerMapper.selectByPage(customer, pagination);
        pagination.setList(list);
        return pagination;
    }

    /**
     * 统计客户构成
     * @return
     */
    @Override
    public Map staticsByType() {
        List<Customer> list = customerMapper.selectAll();
        Map<String, Integer> map = new HashMap<>();
        String rank = null;
        for(Customer customer : list){
            rank = customer.getRank();
            if(map.containsKey(rank)){
                map.put(rank,(map.get(rank)));
            } else {
                map.put(rank,1);
            }
        }
        return map;
    }
}
