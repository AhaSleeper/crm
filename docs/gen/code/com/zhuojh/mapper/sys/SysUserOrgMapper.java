package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysUserOrg;

public interface SysUserOrgMapper {
    int deleteByPrimaryKey(String userOrgId);

    int insert(SysUserOrg record);

    int insertSelective(SysUserOrg record);

    SysUserOrg selectByPrimaryKey(String userOrgId);

    int updateByPrimaryKeySelective(SysUserOrg record);

    int updateByPrimaryKeyWithBLOBs(SysUserOrg record);

    int updateByPrimaryKey(SysUserOrg record);
}