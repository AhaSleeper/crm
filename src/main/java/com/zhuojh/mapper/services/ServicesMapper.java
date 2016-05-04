package com.zhuojh.mapper.services;

import com.zhuojh.model.services.Services;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicesMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);

    int deleteByIds(List<String> idList);

    List<Services> selectByPage(@Param("services") Services services,@Param("page") Pagination page);

    List<Services> listAll(Services services);
}