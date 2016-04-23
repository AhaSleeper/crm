package com.zhuojh.core.interceptor;

import com.zhuojh.model.sys.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/4/22.
 */
@Component("authInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session==null || session.getAttribute("user") == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
