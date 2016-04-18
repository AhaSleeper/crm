package com.zhuojh.service.sys;

import com.zhuojh.model.sys.SysRoleMenu;

import java.util.List;

/**
 * Created by Administrator on 2016/4/17.
 */
public interface SysRoleMenuService {
    boolean deleteByPrimaryKey(String id);
    boolean setRoleMenu(String roleId, String menuIds);
    List<SysRoleMenu> getSysRoleMenu(String roleId);
}
