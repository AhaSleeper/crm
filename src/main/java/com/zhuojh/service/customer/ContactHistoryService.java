package com.zhuojh.service.customer;

import com.zhuojh.model.customer.Contact;
import com.zhuojh.model.customer.ContactHistory;
import common.page.Pagination;

/**
 * Created by Administrator on 2016/4/26.
 */
public interface ContactHistoryService {
    boolean save(ContactHistory contactHistory);
    boolean update(ContactHistory contactHistory);
    boolean deleteByIds(String ids);
    Pagination selectByPage(ContactHistory contactHistory, Integer pageNo, Integer pageSize);
}
