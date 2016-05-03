package com.zhuojh.service.sales.impl;

import com.zhuojh.mapper.sales.CustomerDevPlanMapper;
import com.zhuojh.model.sales.CustomerDevPlan;
import com.zhuojh.service.sales.CustomerDevPlanService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/30.
 */
@Service
public class CustomerDevPlanServiceImpl implements CustomerDevPlanService{
    @Autowired
    private CustomerDevPlanMapper customerDevPlanMapper;

    @Override
    public boolean save(CustomerDevPlan customerDevPlan) {
        customerDevPlan.setCustomerDevPlanId(GuidCreator.getUUID());
        return customerDevPlanMapper.insert(customerDevPlan) > 0;
    }

    @Override
    public boolean update(CustomerDevPlan customerDevPlan) {
        return customerDevPlanMapper.updateByPrimaryKeySelective(customerDevPlan) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return customerDevPlanMapper.deleteByIds(list) > 0;
    }

    @Override
    public Pagination selectByPage(CustomerDevPlan customerDevPlan, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<CustomerDevPlan> list = customerDevPlanMapper.selectByPage(customerDevPlan, page);
        page.setList(list);
        return page;
    }

    @Override
    public List<CustomerDevPlan> selectByOppId(String salesOppId) {
        return customerDevPlanMapper.selectByOppId(salesOppId);
    }


}
