package com.zhuojh.service.sales.impl;

import com.zhuojh.mapper.sales.SalesOppotunityMapper;
import com.zhuojh.model.sales.SalesOppotunity;
import com.zhuojh.service.sales.SalesOppotunityService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/30.
 */
@Service
class SalesOppotunityServiceImpl implements SalesOppotunityService {
    @Autowired
    private SalesOppotunityMapper salesOppotunityMapper;

    @Override
    public boolean save(SalesOppotunity salesOppotunity) {
        salesOppotunity.setSaleOppId(GuidCreator.getUUID());
        return salesOppotunityMapper.insert(salesOppotunity) > 0;
    }

    @Override
    public boolean update(SalesOppotunity salesOppotunity) {
        return salesOppotunityMapper.updateByPrimaryKeySelective(salesOppotunity) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return salesOppotunityMapper.deleteByIds(list);
    }

    @Override
    public Pagination selectByPage(SalesOppotunity salesOppotunity, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<SalesOppotunity> list = salesOppotunityMapper.selectByPage(salesOppotunity, page);
        page.setList(list);
        return page;
    }

    @Override
    public Pagination selectByAssignToPage(SalesOppotunity salesOppotunity, Integer page, Integer rows) {
        Pagination pagination = new Pagination();
        pagination.setPageNo(page);
        pagination.setPageSize(rows);
        List<SalesOppotunity> list = salesOppotunityMapper.selectByAssignToPage(salesOppotunity, pagination);
        pagination.setList(list);
        return pagination;
    }

    @Override
    public SalesOppotunity selectByPrimaryKey(String salesOppId) {
        return salesOppotunityMapper.selectByPrimaryKey(salesOppId);
    }
}
