package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    void deleteByUserId(String userId);

    List<SysUserRole> selectUserRoleByUserId(String userId);
}