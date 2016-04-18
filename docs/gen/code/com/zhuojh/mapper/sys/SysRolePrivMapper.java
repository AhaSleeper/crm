package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysRoleMenu;

public interface SysRolePrivMapper {
    int deleteByPrimaryKey(String privRoleId);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String privRoleId);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}