package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysRoleMapper;
import com.zhuojh.model.sys.SysRole;
import com.zhuojh.service.sys.SysRoleService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/17.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Pagination getRoleyPage(SysRole sysRole, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<SysRole> roleList = sysRoleMapper.selectByPage(sysRole, page);
        page.setList(roleList);
        return page;
    }

    @Override
    public boolean save(SysRole sysRole) {
        sysRole.setRoleId(GuidCreator.getUUID());
        return sysRoleMapper.insert(sysRole) > 0;
    }

    @Override
    public boolean update(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0;
    }

    @Override
    public boolean delete(String id) {
        return sysRoleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByIds(String id) {
        if(id==null)return false;
        String[] idArr = id.split(",");
        List<String> idList = Arrays.asList(idArr);
        return sysRoleMapper.deleteByIds(idList) > 0;
    }
}
