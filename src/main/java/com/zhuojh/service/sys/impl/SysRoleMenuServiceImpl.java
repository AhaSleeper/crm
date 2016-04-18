package com.zhuojh.service.sys.impl;

import ch.qos.logback.classic.gaffer.GafferUtil;
import com.zhuojh.mapper.sys.SysRoleMenuMapper;
import com.zhuojh.model.sys.SysRoleMenu;
import com.zhuojh.service.sys.SysRoleMenuService;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public boolean deleteByPrimaryKey(String id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 角色菜单授权
     * @param roleId
     * @param menuIds
     * @return
     */
    @Override
    public boolean setRoleMenu(String roleId, String menuIds) {
        //删除原来的菜单
        sysRoleMenuMapper.deleteByRoleId(roleId);
        //创建新的菜单角色关联
        String[] menuIdArr = menuIds.split(",");
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setRoleId(roleId);
        boolean flag = true;
        for(String menuId : menuIdArr){
            if(!menuId.equals("")){
                sysRoleMenu.setRoleMenuId(GuidCreator.getUUID());
                sysRoleMenu.setMenuId(menuId);
                flag = sysRoleMenuMapper.insert(sysRoleMenu) > 0;
            }
        }
        return flag;
    }

    @Override
    public List<SysRoleMenu> getSysRoleMenu(String roleId) {
        return sysRoleMenuMapper.getSysRoleMenu(roleId);
    }
}
