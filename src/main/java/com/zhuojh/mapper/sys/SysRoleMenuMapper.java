package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(String privRoleId);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String privRoleId);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    int deleteByRoleId(String roleId);

    List<SysRoleMenu> getSysRoleMenu(String roleId);
}