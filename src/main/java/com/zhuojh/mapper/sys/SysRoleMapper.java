package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysRole;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectByPage(@Param("sysRole") SysRole sysRole, @Param("page") Pagination page);

    int deleteByIds(List<String> idList);
}