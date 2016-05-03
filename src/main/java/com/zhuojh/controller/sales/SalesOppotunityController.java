package com.zhuojh.controller.sales;

import com.zhuojh.model.sales.CustomerDevPlan;
import com.zhuojh.model.sales.SalesOppotunity;
import com.zhuojh.model.sys.SysUser;
import com.zhuojh.service.sales.SalesOppotunityService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/30.
 */
@Controller
@RequestMapping("/salesOppotunity")
public class SalesOppotunityController {

    @Autowired
    private SalesOppotunityService salesOppotunityService;

    @RequestMapping("/main")
    public String main(){
        return "sales/salesOppotunity";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(SalesOppotunity salesOppotunity, Integer page, Integer rows){
        if(page==null || page==0) page=1;
        if(rows==null || rows==0) rows=10;
        Pagination pagination = salesOppotunityService.selectByPage(salesOppotunity, page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }

    @RequestMapping("/assignList")
    @ResponseBody
    public Map assignList(HttpServletRequest request, SalesOppotunity salesOppotunity, Integer page, Integer rows){
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        salesOppotunity.setAssignTo(user.getUserId());
        if(page==null || page==0) page=1;
        if(rows==null || rows==0) rows=10;
        Pagination pagination = salesOppotunityService.selectByAssignToPage(salesOppotunity, page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(HttpServletRequest request, SalesOppotunity salesOppotunity){
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        salesOppotunity.setCreateBy(user.getUserName());
        salesOppotunity.setCreateTime(new Date());
        boolean flag = salesOppotunityService.save(salesOppotunity);
        if(flag) return new JsonData(true, "保存成功", null);
        else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(SalesOppotunity salesOppotunity){
        boolean flag = salesOppotunityService.update(salesOppotunity);
        if(flag) return new JsonData(true, "更新成功", null);
        else return new JsonData(false, "更新失败", null);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = salesOppotunityService.deleteByIds(ids);
        if(flag) return new JsonData(true, "删除成功", null);
        else return new JsonData(false, "删除失败", null);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws ServletException {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
            public String getAsText() {
                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
            }
        });
    }
}
