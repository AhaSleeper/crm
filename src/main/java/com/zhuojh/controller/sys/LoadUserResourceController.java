package com.zhuojh.controller.sys;

import com.zhuojh.model.sys.SysMenu;
import com.zhuojh.model.sys.SysUser;
import com.zhuojh.model.sys.SysUserRole;
import com.zhuojh.service.sys.SysMenuService;
import com.zhuojh.service.sys.SysRoleMenuService;
import com.zhuojh.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
@Controller
public class LoadUserResourceController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/loadUserMenu")
    public String loadUserMenu(HttpServletRequest request){
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("user");
        List<SysUserRole> sysUserRoleList = sysUserRoleService.selectUserRoleByUserId(sysUser.getUserId());
        List<SysMenu> menuList = sysMenuService.getMenuByUserId(sysUser.getUserId());
        List<SysMenu> list = new ArrayList<>();
        for(SysMenu sysMenu : menuList){
            if(sysMenu.getMenuType()!=null && sysMenu.getMenuType().equals(2)){
                list.add(sysMenu);
            }
        }
        List<SysMenu> listWithChild = new ArrayList<>();
        for(SysMenu menu : list){
            List<SysMenu> childMenuList = new ArrayList<>();
            for(SysMenu tempMenu : menuList){
                if(menu.getMenuId().equals(tempMenu.getPid())){
                    childMenuList.add(tempMenu);
                }
            }
            menu.setChildren(childMenuList);
            listWithChild.add(menu);
        }
        session.setAttribute("menuList",listWithChild);
        return "index";
    }
}
