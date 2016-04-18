package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysUser;
import common.page.Pagination;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectByPage(SysUser sysUser, Pagination page);
}