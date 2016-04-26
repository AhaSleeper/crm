package com.zhuojh.mapper.customer;

import com.zhuojh.model.customer.Contact;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactMapper {
    int deleteByPrimaryKey(String contactId);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(String contactId);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    int deleteByIds(List<String> idList);

    List<Contact> selectByPage(@Param("contact") Contact contact, @Param("page") Pagination pagination);
}