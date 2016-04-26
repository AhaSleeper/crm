package com.zhuojh.service.customer;

import com.zhuojh.model.customer.Contact;
import common.page.Pagination;

/**
 * Created by Administrator on 2016/4/25.
 */
public interface ContactService {
    boolean save(Contact contact);
    boolean update(Contact contact);
    boolean deleteByIds(String ids);
    Pagination selectByPage(Contact contact, Integer pageNo, Integer pageSize);
}
