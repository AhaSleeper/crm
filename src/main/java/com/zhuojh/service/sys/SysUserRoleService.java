package com.zhuojh.service.sys;

import com.zhuojh.model.sys.SysUserRole;

import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
public interface SysUserRoleService {
    boolean setUserRole(String userId, String roleIds);

    List<SysUserRole> selectUserRoleByUserId(String userId);
}
