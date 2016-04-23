package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysUserRoleMapper;
import com.zhuojh.model.sys.SysUserRole;
import com.zhuojh.service.sys.SysUserRoleService;
import com.zhuojh.service.sys.SysUserService;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public boolean setUserRole(String userId, String roleIds) {
        //删除原来的角色
        sysUserRoleMapper.deleteByUserId(userId);
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(userId);
        boolean flag = true;
        if(roleIds!=null && !"".equals(roleIds)){
            String[] idArr = roleIds.split(",");
            for(String id : idArr){
                userRole.setUserRoleId(GuidCreator.getUUID());
                userRole.setRoleId(id);
                flag = sysUserRoleMapper.insert(userRole)>0;
            }
        }
        return flag;
    }

    @Override
    public List<SysUserRole> selectUserRoleByUserId(String userId) {
        return sysUserRoleMapper.selectUserRoleByUserId(userId);
    }
}
