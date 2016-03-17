package com.zhuojh.service.sys.impl;

import com.zhuojh.mapper.sys.SysMenuMapper;
import com.zhuojh.model.sys.SysMenu;
import com.zhuojh.service.sys.SysMenuService;
import com.zhuojh.vo.AdditionalParameters;
import com.zhuojh.vo.TreeItem;
import com.zhuojh.vo.TreeRespVo;
import com.zhuojh.vo.TreeVo;
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

    @Override
    public Map<String,TreeItem> getMenuTree(SysMenu menu) {
        List<SysMenu> sysMenuParentList = sysMenuMapper.selectByPid(menu);
        Map<String,TreeItem> treeMap = new HashMap<String, TreeItem>();
        for(SysMenu sysMenu : sysMenuParentList){
            treeMap.put(sysMenu.getMenuId(), tree(sysMenu, true));
        }
        return treeMap;
    }

    public TreeItem tree(SysMenu menu,boolean isRecursive){
//        TreeVo node = new TreeVo();
        TreeItem treeItem = new TreeItem();
        Map<String, Object> attr = new HashMap<String, Object>();
        attr.put("id",menu.getMenuId());
        attr.put("pid",menu.getPid());
        attr.put("data-icon", menu.getMenuIcon());
        attr.put("style", null);
//        node.setText(menu.getMenuName());
        treeItem.setName(menu.getMenuName());
//        node.setAttr(attr);
        AdditionalParameters additionalParameters = new AdditionalParameters();
        additionalParameters.setId(menu.getMenuId());
        treeItem.setAdditionalParameters(additionalParameters);
        List<SysMenu> sysMenuParentList = sysMenuMapper.getMenuList(menu);
        if(sysMenuParentList!=null && sysMenuParentList.size() >0){
//            node.setType(TreeVo.TYPE_FOLDER);
            treeItem.setType(TreeItem.TYPE_FOLDER);
            if(isRecursive){
                List<TreeItem> childMenuList = new ArrayList<TreeItem>();
                for(SysMenu sysMenu : sysMenuParentList){
                    childMenuList.add(tree(sysMenu,true));
                }
                additionalParameters.setChildren(childMenuList);
//                node.setChildren(childMenuList);
                treeItem.setAdditionalParameters(additionalParameters);
            }
        } else {
            treeItem.setType(TreeItem.TYPE_ITEM);
        }
        return treeItem;
    }
}
