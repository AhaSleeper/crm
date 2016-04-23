package com.zhuojh.service.sys;

import com.zhuojh.model.sys.SysUser;
import common.page.Pagination;

/**
 * Created by snow on 2016/3/9.
 */
public interface SysUserService {
    boolean save(SysUser user);
    boolean update(SysUser user);
    boolean delete(String id);
    boolean deleteByIds(String ids);
    SysUser selectByPrimaryKey(String id);
    /**
     * 分页查询用户
     * @param sysUser
     * @param pageNo
     * @param pageSize
     * @return
     */
    Pagination getUserByPage(SysUser sysUser, Integer pageNo, Integer pageSize);

    SysUser loadUserByName(String userName);
}
