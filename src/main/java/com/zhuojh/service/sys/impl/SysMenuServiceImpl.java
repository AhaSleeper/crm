package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysMenuMapper;
import com.zhuojh.model.sys.SysMenu;
import com.zhuojh.service.sys.SysMenuService;
import com.zhuojh.vo.AdditionalParameters;
import com.zhuojh.vo.TreeItem;
import com.zhuojh.vo.TreeRespVo;
import com.zhuojh.vo.TreeView;
import common.util.GuidCreator;
import common.util.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by snow on 2016/3/14.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public boolean addMenu(SysMenu sysMenu) {
        sysMenu.setMenuId(GuidCreator.getUUID());
        return sysMenuMapper.insert(sysMenu) > 0;
    }

    @Override
    public boolean updateMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu) > 0;
    }

    @Override
    public boolean deleteMenu(String id) {
        return sysMenuMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * Fuel ux Tree
     * @param menu
     * @return
     */
    @Override
    public Map<String,TreeItem> getMenuTree(SysMenu menu) {
        List<SysMenu> sysMenuParentList = sysMenuMapper.selectByPid(menu);
        Map<String,TreeItem> treeMap = new HashMap<String, TreeItem>();
        for(SysMenu sysMenu : sysMenuParentList){
            treeMap.put(sysMenu.getMenuId(), tree(sysMenu, true));
        }
        return treeMap;
    }

    /**
     * Fuel ux Tree
     * @param menu
     * @param isRecursive
     * @return
     */
    public TreeItem tree(SysMenu menu,boolean isRecursive){
        TreeItem treeItem = new TreeItem();
        treeItem.setText(menu.getMenuName());
        AdditionalParameters additionalParameters = new AdditionalParameters();
        additionalParameters.setId(menu.getMenuId());
        additionalParameters.setPid(menu.getPid());
        additionalParameters.setIcon(menu.getMenuIcon());
        additionalParameters.setUrl(menu.getMenuUrl());
        additionalParameters.setpName(menu.getpName());
        additionalParameters.setSeq(menu.getSeq());
        additionalParameters.setMenuType(menu.getMenuType());
        additionalParameters.setMenuTypeStr(menu.getMenuTypeStr());
        treeItem.setAdditionalParameters(additionalParameters);
        List<SysMenu> sysMenuParentList = sysMenuMapper.getMenuList(menu);
        if(sysMenuParentList!=null && sysMenuParentList.size() >0){
            treeItem.setType(TreeItem.TYPE_FOLDER);
            if(isRecursive){
                List<TreeItem> childMenuList = new ArrayList<TreeItem>();
                for(SysMenu sysMenu : sysMenuParentList){
                    childMenuList.add(tree(sysMenu,true));
                }
                additionalParameters.setChildren(childMenuList);
                treeItem.setAdditionalParameters(additionalParameters);
            }
        } else {
            treeItem.setType(TreeItem.TYPE_ITEM);
        }
        return treeItem;
    }

    /**
     * zTree
     * @param sysMenu
     * @return
     */
    @Override
    public List<TreeView> getMenuList(SysMenu sysMenu) {
        List<SysMenu> sysMenuList = sysMenuMapper.getMenuList(sysMenu);
        List<TreeView> treeViews = new ArrayList<>();
        for(SysMenu menu : sysMenuList){
            treeViews.add(treeView(menu,true));
        }
        return treeViews;
    }

    /**
     * zTree
     * @param sysMenu
     * @param recursive
     * @return
     */
    public TreeView treeView(SysMenu sysMenu, boolean recursive){
        TreeView node = new TreeView();
        node.setId(sysMenu.getMenuId());
        node.setpId(sysMenu.getPid());
        node.setName(sysMenu.getMenuName());
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("pid",sysMenu.getPid());
        attributes.put("seq", sysMenu.getSeq());
        node.setAttributes(attributes);
        SysMenu res = new SysMenu();
        res.setPid(sysMenu.getMenuId());
        List<SysMenu> childrendList = sysMenuMapper.getMenuList(sysMenu);
        if(!PublicUtil.checkEmptyList(childrendList)){
            if(recursive){
                List<TreeView> childrendNode = new ArrayList<TreeView>();
                for(SysMenu menu : childrendList){
                    TreeView childrend = treeView(menu, true);
                    childrendNode.add(childrend);
                }
                node.setChildren(childrendNode);
            }

        }
        return node;
    }
}
