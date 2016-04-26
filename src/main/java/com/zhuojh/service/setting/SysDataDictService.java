package com.zhuojh.service.setting;

import com.zhuojh.model.setting.SysDataDict;
import common.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface SysDataDictService {
    boolean save(SysDataDict sysDataDict);
    boolean update(SysDataDict sysDataDict);
    boolean delete(String id);
    Pagination selectByPage(SysDataDict sysDataDict, Integer pageNo, Integer pageSize);

    List<SysDataDict> getListByType(String type);
}
