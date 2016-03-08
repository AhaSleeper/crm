package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysRolePriv;

public interface SysRolePrivMapper {
    int deleteByPrimaryKey(String privRoleId);

    int insert(SysRolePriv record);

    int insertSelective(SysRolePriv record);

    SysRolePriv selectByPrimaryKey(String privRoleId);

    int updateByPrimaryKeySelective(SysRolePriv record);

    int updateByPrimaryKey(SysRolePriv record);
}