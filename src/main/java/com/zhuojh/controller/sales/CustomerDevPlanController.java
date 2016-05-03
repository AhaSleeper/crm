package com.zhuojh.controller.sales;

import com.zhuojh.model.sales.CustomerDevPlan;
import com.zhuojh.model.sales.SalesOppotunity;
import com.zhuojh.service.sales.CustomerDevPlanService;
import com.zhuojh.service.sales.SalesOppotunityService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/30.
 */
@Controller
@RequestMapping("/customerDevPlan")
public class CustomerDevPlanController {

    @Autowired
    private SalesOppotunityService salesOppotunityService;

    @Autowired
    private CustomerDevPlanService customerDevPlanService;

    @RequestMapping("/main")
    public String main(){
        return "sales/customerDevPlan";
    }

    @RequestMapping("/makePlan")
    public String makePlan(String salesOppId, ModelMap modelMap){
        SalesOppotunity salesOppotunity = salesOppotunityService.selectByPrimaryKey(salesOppId);
        List<CustomerDevPlan> list = customerDevPlanService.selectByOppId(salesOppId);
        modelMap.addAttribute("planList",list);
        modelMap.addAttribute("oppo",salesOppotunity);
        return "sales/makePlan";
    }

    @RequestMapping("/execPlan")
    public String execPlan(String salesOppId, ModelMap modelMap){
        SalesOppotunity salesOppotunity = salesOppotunityService.selectByPrimaryKey(salesOppId);
        List<CustomerDevPlan> list = customerDevPlanService.selectByOppId(salesOppId);
        modelMap.addAttribute("planList",list);
        modelMap.addAttribute("oppo",salesOppotunity);
        return "sales/execPlan";
    }
    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(CustomerDevPlan customerDevPlan){
        boolean flag = customerDevPlanService.save(customerDevPlan);
        if(flag) return new JsonData(true, "保存成功", null);
        else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(CustomerDevPlan customerDevPlan){
        boolean flag = customerDevPlanService.update(customerDevPlan);
        if(flag) return new JsonData(true, "更新成功", null);
        else return new JsonData(false, "更新失败", null);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = customerDevPlanService.deleteByIds(ids);
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
