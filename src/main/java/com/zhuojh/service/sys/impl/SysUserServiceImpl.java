package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysUserMapper;
import com.zhuojh.model.sys.SysUser;
import com.zhuojh.service.sys.SysUserService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean save(SysUser user) {
        user.setUserId(GuidCreator.getUUID());
        return sysUserMapper.insert(user) > 0;
    }

    @Override
    public boolean update(SysUser user) {
        return sysUserMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public boolean delete(String id) {
        return sysUserMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        boolean flag = true;
        if(ids!=null && !"".equals(ids)){
            String[] idArr = ids.split(",");
            List<String> idList = Arrays.asList(idArr);
            flag = sysUserMapper.deleteByIds(idList);
        }
        return flag;
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

    @Override
    public SysUser loadUserByName(String userName) {
        return sysUserMapper.selectByUserName(userName);
    }
}
