package com.zhuojh.controller.sys;

import com.zhuojh.model.sys.SysRole;
import com.zhuojh.model.sys.SysRoleMenu;
import com.zhuojh.service.sys.SysRoleMenuService;
import com.zhuojh.service.sys.SysRoleService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/15.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("/main")
    public String main(){
        return "sys/role/roleList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> getRoleList(SysRole sysRole, Integer page, Integer rows){
        if(page==null || page==0) page=1;
        if(rows==null || rows == 0) rows = 10;
        Pagination pagination = sysRoleService.getRoleyPage(sysRole, page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }
    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(SysRole role){
        boolean flag = sysRoleService.save(role);
        if(flag){
            return new JsonData(true, "保存成功", null);
        } else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(SysRole role){
        boolean flag = sysRoleService.update(role);
        if(flag){
            return new JsonData(true, "更新成功", null);
        } else return new JsonData(false, "更新失败", null);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = sysRoleService.deleteByIds(ids);
        if(flag){
            return new JsonData(true, "删除成功", null);
        } else return new JsonData(false, "删除失败", null);
    }

    /**
     * 按ID删除
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public JsonData deleteById(String roleId){
        boolean flag = sysRoleService.delete(roleId);
        if(flag){
            return new JsonData(true, "删除成功", null);
        } else return new JsonData(false, "删除失败", null);
    }

    /**
     * 角色菜单授权
     * @param roleId
     * @param menuIds
     * @return
     */
    @RequestMapping("/setRoleMenu")
    @ResponseBody
    public JsonData setRoleMenu(HttpServletRequest request,String roleId, String menuIds){
        String role = request.getParameter("roleId");
        String ids1 = request.getParameter("ids");
        boolean flag = sysRoleMenuService.setRoleMenu(roleId, menuIds);
        if(flag){
            return new JsonData(true, "授权成功",null);
        } else {
            return new JsonData(false, "授权失败", null);
        }
    }

    /**
     * 查询角色授权信息
     * @param roleId
     * @return
     */
    @RequestMapping("/getSysRoleMenu")
    @ResponseBody
    public List<SysRoleMenu> getSysRoleMenu(String roleId){
        List<SysRoleMenu> list = sysRoleMenuService.getSysRoleMenu(roleId);
        return list;
    }
}
