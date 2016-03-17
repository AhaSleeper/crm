package com.zhuojh.controller.sys;

import com.zhuojh.model.sys.SysMenu;
import com.zhuojh.service.sys.SysMenuService;
import com.zhuojh.vo.TreeItem;
import com.zhuojh.vo.TreeRespVo;
import com.zhuojh.vo.TreeVo;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by snow on 2016/3/13.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 去菜单管理页面
     * @return
     */
    @RequestMapping("/main")
    public String main(){
        return "sys/menu";
    }


    /**
     * 获取菜单树
     * @return
     */
    @RequestMapping("/tree")
    @ResponseBody
    public Map<String,TreeItem> getMenuTree(String pid){
        SysMenu sysMenu = new SysMenu();
        if(pid == null || pid.equals("0")){
            sysMenu.setPid(null);
        } else {
            sysMenu.setPid(pid);
        }
        return sysMenuService.getMenuTree(sysMenu);
    }

    /**
     *
     * @param id
     * @return
     */
    public JsonData getMenuById(String id){
        return null;
    }
    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @RequestMapping("/addMenu")
    @ResponseBody
    public JsonData addMenu(SysMenu sysMenu){
        boolean flag = sysMenuService.addMenu(sysMenu);
        if(flag){
            return new JsonData(true,"添加成功",null);
        } else {
            return new JsonData(false, "添加失败", null);
        }
    }

    /**
     * 更新菜单
     * @param sysMenu
     * @return
     */
    @RequestMapping("/updateMenu")
    @ResponseBody
    public JsonData updateMenu(SysMenu sysMenu){
        boolean flag = sysMenuService.updateMenu(sysMenu);
        if(flag){
            return new JsonData(true,"更新成功",null);
        } else {
            return new JsonData(false, "更新失败", null);
        }
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public JsonData deleteMenu(String id){
        boolean flag = sysMenuService.deleteMenu(id);
        if(flag){
            return new JsonData(true,"删除成功",null);
        } else {
            return new JsonData(false, "删除失败", null);
        }
    }

}
