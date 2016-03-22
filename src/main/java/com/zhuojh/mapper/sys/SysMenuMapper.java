package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectByPidIsNull();
    List<SysMenu> getMenuList(SysMenu sysMenu);

    List<SysMenu> selectByPid(SysMenu sysMenu);
}