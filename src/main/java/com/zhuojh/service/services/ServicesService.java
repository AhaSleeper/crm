package com.zhuojh.service.services;

import com.zhuojh.model.services.Services;
import common.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2016/5/3.
 */
public interface ServicesService {
    boolean save(Services services);
    boolean update(Services services);
    boolean deleteByIds(String ids);
    Pagination selectByPage(Services services, Integer pageNo, Integer pageSize);

    Services selectByPrimaryKey(String serviceId);

    List<Services> listAll(Services services);
}
