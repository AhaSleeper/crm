package com.zhuojh.service.sales;

import com.zhuojh.model.sales.CustomerDevPlan;
import common.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2016/4/30.
 */
public interface CustomerDevPlanService {
    boolean save(CustomerDevPlan customerDevPlan);
    boolean update(CustomerDevPlan customerDevPlan);
    boolean deleteByIds(String ids);
    Pagination selectByPage(CustomerDevPlan customerDevPlan, Integer pageNo, Integer pageSize);

    List<CustomerDevPlan> selectByOppId(String salesOppId);
}
