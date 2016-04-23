package com.zhuojh.controller.setting;

import com.zhuojh.model.setting.SysDataDict;
import com.zhuojh.service.setting.SysDataDictService;
import common.page.Pagination;
import common.web.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
@Controller
@RequestMapping("/data")
public class DataDictController {

    @Autowired
    private SysDataDictService sysDataDictService;

    @RequestMapping("/main")
    public String main(){
        return "setting/data_dictionary";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(SysDataDict sysDataDict, Integer page, Integer rows){
        if(page==null || page==0)page = 1;
        if(rows==null || rows==0) rows = 10;
        Pagination pagination = sysDataDictService.selectByPage(sysDataDict,page, rows);
        Map map = new HashMap<String, Object>();
        map.put("total",pagination.getTotalPage());
        map.put("page", pagination.getPageNo());
        map.put("records", pagination.getTotalCount());
        map.put("rows",pagination.getList());
        return map;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonData save(SysDataDict sysDataDict){
        boolean flag = sysDataDictService.save(sysDataDict);
        if(flag) {
            return new JsonData(true, "保存成功", null);
        } else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonData update(SysDataDict sysDataDict){
        boolean flag = sysDataDictService.update(sysDataDict);
        if(flag) {
            return new JsonData(true, "保存成功", null);
        } else return new JsonData(false, "保存失败", null);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonData delete(String ids){
        boolean flag = sysDataDictService.delete(ids);
        if(flag) {
            return new JsonData(true, "删除成功", null);
        } else return new JsonData(false, "删除失败", null);
    }

}
