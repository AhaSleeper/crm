package com.zhuojh.mapper.customer;

import com.zhuojh.model.customer.ContactHistory;

public interface ContactHistoryMapper {
    int deleteByPrimaryKey(String contactHistId);

    int insert(ContactHistory record);

    int insertSelective(ContactHistory record);

    ContactHistory selectByPrimaryKey(String contactHistId);

    int updateByPrimaryKeySelective(ContactHistory record);

    int updateByPrimaryKey(ContactHistory record);
}