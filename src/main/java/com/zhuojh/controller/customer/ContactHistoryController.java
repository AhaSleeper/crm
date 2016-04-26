package com.zhuojh.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/4/25.
 */
@Controller
@RequestMapping("/contactHistory")
public class ContactHistoryController {

    @RequestMapping("/main")
    public String main(String customerId, ModelMap map){
        map.addAttribute("customerId",customerId);
        return "customer/contactHistory";
    }
}
