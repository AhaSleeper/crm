package com.zhuojh.mapper.customer;

import com.zhuojh.model.customer.ContactHistory;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactHistoryMapper {
    int deleteByPrimaryKey(String contactHistId);

    int insert(ContactHistory record);

    int insertSelective(ContactHistory record);

    ContactHistory selectByPrimaryKey(String contactHistId);

    int updateByPrimaryKeySelective(ContactHistory record);

    int updateByPrimaryKey(ContactHistory record);

    boolean deleteByIds(List<String> idList);

    List<ContactHistory> selectByPage(@Param("contactHistory") ContactHistory contactHistory, @Param("page") Pagination page);
}