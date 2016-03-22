package com.zhuojh.controller;

import com.zhuojh.model.User;
import com.zhuojh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by snow on 2016/2/16.
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById")
    public String getUserById(@RequestParam(value="id") String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        logger.info("-----------CRM getUserById--------------");
        return "userInfo";
    }


    @RequestMapping("/index")
    public String index1(){
        return "index";
    }

    @RequestMapping("/sidebar")
    public String sidebar(){
        return "sidebar";
    }

    @RequestMapping("/htmlhead")
    public String htmlHead(){
        return "htmlhead";
    }

    @RequestMapping("/htmlfoot")
    public String htmlfoot(){
        return "htmlfoot";
    }

}
