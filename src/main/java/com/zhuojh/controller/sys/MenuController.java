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

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String main(HttpServletRequest request){
        HttpSession session = request.getSession();
        
        return "sys/menu/menu";
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
     * 保存菜单
     * @param sysMenu
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
   public JsonData saveMenu(SysMenu sysMenu){
       boolean flag = false;
       JsonData jsonData = null;
       if(sysMenu.getMenuId()==null || sysMenu.getMenuId().equals("")){
           flag = sysMenuService.addMenu(sysMenu);
       } else {
           flag = sysMenuService.updateMenu(sysMenu);
       }
       if(flag) jsonData = new JsonData(true, "操作成功", null);
       else jsonData = new JsonData(false, "操作失败", null);
       return jsonData;
   }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @RequestMapping("/delete")
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
