package com.zhuojh.controller.sys;

import com.zhuojh.model.sys.SysUser;
import com.zhuojh.model.sys.SysUserRole;
import com.zhuojh.service.sys.SysUserRoleService;
import com.zhuojh.service.sys.SysUserService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     *
     * @return
     */
    @RequestMapping("/main")
    public String main(){
        return "sys/user/userList";
    }
    /**
     * 获取用户列表
     * @param sysUser
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(SysUser sysUser, Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        if(page==null || page == 0)page=1;
        if(rows==null || rows==0) rows=10;
        Pagination pagination = sysUserService.getUserByPage(sysUser,page, rows);
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/listAll")
    @ResponseBody
    public List<SysUser> listAll(){
        List<SysUser> userList = sysUserService.listAll();
        return userList;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(SysUser user){
        boolean flag = sysUserService.save(user);
        if(flag){
            return new JsonData(true, "保存成功", null);
        } else return new JsonData(false, "保存失败", null);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(SysUser user){
        boolean flag = sysUserService.update(user);
        if(flag){
            return new JsonData(true, "更新成功", null);
        } else return new JsonData(false, "更新失败", null);
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = sysUserService.deleteByIds(ids);
        if(flag){
            return new JsonData(true,"删除成功",null);
        } else return new JsonData(false, "删除失败", null);
    }

    /**
     * 查询用户角色信息
     * @param userId
     * @return
     */
    @RequestMapping("/getUserRole")
    @ResponseBody
    public List<SysUserRole> getUserRole(String userId){
        List<SysUserRole> list = sysUserRoleService.selectUserRoleByUserId(userId);
        return list;
    }
    /**
     * 用户角色分配
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("/setUserRole")
    @ResponseBody
    public JsonData setUserRole(String userId, String roleIds){
        boolean flag = sysUserRoleService.setUserRole(userId, roleIds);
        if(flag){
            return new JsonData(true, "保存成功", null);
        } else return new JsonData(false, "保存失败", null);
    }

}
