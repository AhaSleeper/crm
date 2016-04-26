package com.zhuojh.controller.customer;

import com.zhuojh.model.customer.Contact;
import com.zhuojh.service.customer.ContactService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/25.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/main")
    public String main(HttpServletRequest request, String customerId){
        HttpSession session = request.getSession();
        session.setAttribute("customerId",customerId);
        return "customer/contact";
    }

    /**
     *
     * @param contact
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Contact contact, Integer page, Integer rows){
        if(page == null || page==0) page = 1;
        if(rows == null || rows==0) rows = 10;
        Pagination pagination = contactService.selectByPage(contact, page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows", pagination.getList());
        return map;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(HttpServletRequest request, Contact contact){
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        contact.setCustomerId(customerId);
        boolean flag = contactService.save(contact);
        if(flag) return new JsonData(true, "保存成功", null);
        else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(Contact contact){
        boolean flag = contactService.update(contact);
        if(flag) return new JsonData(true, "更新成功", null);
        else return new JsonData(false, "更新失败", null);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = contactService.deleteByIds(ids);
        if(flag) return new JsonData(true, "删除成功", null);
        else return new JsonData(false, "删除失败", null);
    }
}
