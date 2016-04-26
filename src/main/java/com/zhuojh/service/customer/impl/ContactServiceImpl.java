package com.zhuojh.service.customer.impl;

import com.zhuojh.mapper.customer.ContactMapper;
import com.zhuojh.model.customer.Contact;
import com.zhuojh.service.customer.ContactService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/25.
 */
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public boolean save(Contact contact) {
        contact.setContactId(GuidCreator.getUUID());
        return contactMapper.insert(contact) > 0;
    }

    @Override
    public boolean update(Contact contact) {
        return contactMapper.updateByPrimaryKeySelective(contact) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        List<String> idList = Arrays.asList(idArr);
        return contactMapper.deleteByIds(idList) > 0;
    }

    @Override
    public Pagination selectByPage(Contact contact, Integer pageNo, Integer pageSize) {
        Pagination pagination = new Pagination();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        List<Contact> list = contactMapper.selectByPage(contact, pagination);
        pagination.setList(list);
        return pagination;
    }
}
