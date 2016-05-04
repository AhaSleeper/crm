package com.zhuojh.controller.services;

import com.zhuojh.model.customer.Customer;
import com.zhuojh.model.services.Services;
import com.zhuojh.model.setting.SysDataDict;
import com.zhuojh.model.sys.SysUser;
import com.zhuojh.service.services.ServicesService;
import com.zhuojh.service.setting.SysDataDictService;
import com.zhuojh.service.sys.SysUserService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/3.
 */
@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDataDictService sysDataDictService;

    @RequestMapping("/main")
    public String main(){
        return "services/create";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Services services, Integer page, Integer rows){
        if(page==null || page==0) page = 1;
        if(rows==null || rows==0) rows = 10;
        Pagination pagination = servicesService.selectByPage(services, page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total", pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }

    @RequestMapping("/assignList")
    public String assignList(Services services, Integer page, Integer sizePerPage, ModelMap map){
        if(page==null || page==0) page = 1;
        if(sizePerPage==null || sizePerPage==0) sizePerPage = 10;
        Pagination pagination = servicesService.selectByPage(services, page, sizePerPage);
        List<SysUser> userList = sysUserService.listAll();
        map.addAttribute("page", pagination);
        map.addAttribute("userList", userList);
        if(services.getState().equals(0)){
            return "services/assign";
        } else if(services.getState().equals(3)){
            return "services/feedBack";
        } else  if(services.getState().equals(4)){
            return "services/file";
        } else return null;
    }

    @RequestMapping("/handleList")
    public String handleList(HttpServletRequest request,Services services, Integer page, Integer sizePerPage, ModelMap map){
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        services.setAssignTo(user.getUserId());
        if(page==null || page==0) page = 1;
        if(sizePerPage==null || sizePerPage==0) sizePerPage = 10;
        Pagination pagination = servicesService.selectByPage(services, page, sizePerPage);
        map.addAttribute("page",pagination);
        return "services/handle";
    }

    @RequestMapping("/handleService")
    public String handleService(String serviceId, ModelMap map){
        Services services = servicesService.selectByPrimaryKey(serviceId);
        map.addAttribute("service", services);
        return "services/handleInfo";
    }

    @RequestMapping("/feedBackInfo")
    public String feedBack(String serviceId,String type, ModelMap map){
        Services services = servicesService.selectByPrimaryKey(serviceId);
        List<SysDataDict> list = sysDataDictService.getListByType(type);
        map.addAttribute("service", services);
        map.addAttribute("dataList",list);
        return "services/feedBackInfo";
    }

    @RequestMapping("/fileInfo")
    public String fileInfo(String serviceId,ModelMap map){
        Services services = servicesService.selectByPrimaryKey(serviceId);
        map.addAttribute("service", services);
        return "services/fileInfo";
    }


    @RequestMapping("/feedBack")
    @ResponseBody
    public JsonData feedBackInfo(Services services){
        if(services.getSatisfyRate()!=null && Integer.valueOf(services.getSatisfyRate()) >=3){
            services.setState(4);
        } else {
            services.setState(1);
        }
        boolean flag = servicesService.update(services);
        if(flag) return new JsonData(true, "更新成功", null);
        else return new JsonData(false, "更新失败", null);
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(HttpServletRequest request, Services services){
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        services.setCreateBy(user.getUserName());
        services.setCreateDate(new Date());
        services.setState(0);
        boolean flag = servicesService.save(services);
        if(flag) return new JsonData(true, "保存成功", null);
        else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(Services services){
        if(services.getServiceHandling()!=null && !"".equals(services.getServiceHandling())){
            services.setState(2);
        }
        boolean flag = servicesService.update(services);
        if (flag) return new JsonData(true, "更新成功", null);
        else return new JsonData(false, "更新失败", null);
    }

    @RequestMapping("/handle")
    @ResponseBody
    public JsonData handle(HttpServletRequest request,Services services){
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        services.setState(3);
        services.setHandleBy(user.getUserName());
        services.setHandleDate(new Date());
        boolean flag = servicesService.update(services);
        if (flag) return new JsonData(true, "处理成功", null);
        else return new JsonData(false, "处理失败", null);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonData deleteByIds(String ids){
        boolean flag = servicesService.deleteByIds(ids);
        if(flag) return new JsonData(true, "删除成功", null);
        else return new JsonData(true, "删除失败", null);
    }

    @RequestMapping("/statistics")
    public String statistics(Services services, ModelMap modelMap){
        List<Services> list = servicesService.listAll(services);
        Map<String, Integer> map = new HashMap<>();
        for(Services service : list){
            if(map.containsKey(service.getServiceType())){
                map.put(service.getServiceType(), map.get(service.getServiceType()) + 1);
            } else {
                map.put(service.getServiceType(),1);
            }
        }
        modelMap.addAttribute("map",map);
        return "statistics/services";
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
