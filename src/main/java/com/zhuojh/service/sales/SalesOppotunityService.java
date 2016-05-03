package com.zhuojh.service.sales;

import com.zhuojh.model.sales.SalesOppotunity;
import common.page.Pagination;

/**
 * Created by Administrator on 2016/4/30.
 */
public interface SalesOppotunityService {
    boolean save(SalesOppotunity salesOppotunity);
    boolean update(SalesOppotunity salesOppotunity);
    boolean deleteByIds(String ids);
    Pagination selectByPage(SalesOppotunity salesOppotunity, Integer pageNo, Integer pageSize);

    Pagination selectByAssignToPage(SalesOppotunity salesOppotunity, Integer page, Integer rows);

    SalesOppotunity selectByPrimaryKey(String salesOppId);
}
