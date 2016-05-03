package com.zhuojh.service.customer.impl;

import com.zhuojh.mapper.customer.ContactHistoryMapper;
import com.zhuojh.model.customer.ContactHistory;
import com.zhuojh.service.customer.ContactHistoryService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
@Service
public class ContactHistoryServiceImpl implements ContactHistoryService{
    @Autowired
    private ContactHistoryMapper contactHistoryMapper;

    @Override
    public boolean save(ContactHistory contactHistory) {
        contactHistory.setContactHistId(GuidCreator.getUUID());
        return contactHistoryMapper.insert(contactHistory) > 0;
    }

    @Override
    public boolean update(ContactHistory contactHistory) {
        return contactHistoryMapper.updateByPrimaryKeySelective(contactHistory) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        return contactHistoryMapper.deleteByIds(idList);
    }

    @Override
    public Pagination selectByPage(ContactHistory contactHistory, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<ContactHistory> list = contactHistoryMapper.selectByPage(contactHistory, page);
        page.setList(list);
        return page;
    }
}
