package com.zhuojh.mapper.services;

import com.zhuojh.model.services.Services;

public interface ServicesMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);
}