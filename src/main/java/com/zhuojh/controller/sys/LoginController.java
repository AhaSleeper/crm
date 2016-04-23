package com.zhuojh.controller.sys;

import com.zhuojh.model.sys.SysUser;
import com.zhuojh.service.sys.SysUserService;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/4/19.
 */
@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public JsonData doLogin(HttpServletRequest request,SysUser user){
        SysUser sysUser = sysUserService.loadUserByName(user.getUserName());
        if(sysUser!=null){
            if(user.getPassword().equals(sysUser.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("user",sysUser);
                return new JsonData(true, "登录成功", null);
            } else {
                return new JsonData(false,"密码错误",null);
            }
        } else {//用户不存在
            return new JsonData(false,"用户不存在!", null);
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return "login";
    }
}
