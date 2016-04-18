package com.zhuojh.service.sys;

import com.zhuojh.model.sys.SysRole;
import common.page.Pagination;

import java.util.List;

/**
 * Created by snow on 2016/3/9.
 */
public interface SysRoleService {
    /**
     * 分页查询角色
     * @param sysRole
     * @param pageNo
     * @param pageSize
     * @return
     */
    Pagination getRoleyPage(SysRole sysRole, Integer pageNo, Integer pageSize);
    boolean save(SysRole sysRole);
    boolean update(SysRole sysRole);
    boolean delete(String id);

    boolean deleteByIds(String ids);
}