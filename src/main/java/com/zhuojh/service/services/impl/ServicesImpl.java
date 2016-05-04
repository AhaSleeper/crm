package com.zhuojh.service.services.impl;

import com.zhuojh.mapper.services.ServicesMapper;
import com.zhuojh.model.services.Services;
import com.zhuojh.service.services.ServicesService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/5/3.
 */
@Service
public class ServicesImpl implements ServicesService {
    @Autowired
    private ServicesMapper servicesMapper;

    @Override
    public boolean save(Services services) {
        services.setServiceId(GuidCreator.getUUID());
        return servicesMapper.insert(services) > 0;
    }

    @Override
    public boolean update(Services services) {
        return servicesMapper.updateByPrimaryKeySelective(services) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        return servicesMapper.deleteByIds(idList) > 0;
    }

    @Override
    public Pagination selectByPage(Services services, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<Services> list = servicesMapper.selectByPage(services, page);
        page.setList(list);
        return page;
    }

    @Override
    public Services selectByPrimaryKey(String serviceId) {
        return servicesMapper.selectByPrimaryKey(serviceId);
    }

    @Override
    public List<Services> listAll(Services services) {
        return servicesMapper.listAll(services);
    }
}
