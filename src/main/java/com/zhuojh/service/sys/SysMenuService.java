package com.zhuojh.service.sys;

import com.zhuojh.model.sys.SysMenu;
import com.zhuojh.vo.TreeItem;
import com.zhuojh.vo.TreeRespVo;
import com.zhuojh.vo.TreeView;

import java.util.List;
import java.util.Map;

/**
 * Created by snow on 2016/3/9.
 */
public interface SysMenuService {
    public boolean addMenu(SysMenu sysMenu);
    public boolean updateMenu(SysMenu sysMenu);
    public boolean deleteMenu(String id);
    public Map<String,TreeItem> getMenuTree(SysMenu sysMenu);

    public List<TreeView> getMenuList(SysMenu sysMenu);

    List<SysMenu> getMenuByUserId(String userId);
}
