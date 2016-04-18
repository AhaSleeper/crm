package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysUserMapper;
import com.zhuojh.model.sys.SysUser;
import com.zhuojh.service.sys.SysUserService;
import common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean save(SysUser user) {
        return sysUserMapper.insert(user) > 0;
    }

    @Override
    public boolean update(SysUser user) {
        return sysUserMapper.insert(user) > 0;
    }

    @Override
    public boolean delete(String id) {
        return sysUserMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Pagination getUserByPage(SysUser sysUser, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<SysUser> list = sysUserMapper.selectByPage(sysUser, page);
        page.setList(list);
        return page;
    }
}
