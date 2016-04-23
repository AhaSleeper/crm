package com.zhuojh.service.setting.impl;

import com.zhuojh.mapper.setting.SysDataDictMapper;
import com.zhuojh.model.setting.SysDataDict;
import com.zhuojh.service.setting.SysDataDictService;
import common.page.Pagination;
import common.util.GuidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service
public class SysDataDictServiceImpl implements SysDataDictService{
    @Autowired
    private SysDataDictMapper sysDataDictMapper;

    @Override
    public boolean save(SysDataDict sysDataDict) {
        sysDataDict.setDataDictionaryId(GuidCreator.getUUID());
        return sysDataDictMapper.insert(sysDataDict) > 0;
    }

    @Override
    public boolean update(SysDataDict sysDataDict) {
        return sysDataDictMapper.updateByPrimaryKeySelective(sysDataDict) > 0;
    }

    @Override
    public boolean delete(String ids) {
        String[] idsArr = ids.split(",");
        List<String> idList = Arrays.asList(idsArr);
        return sysDataDictMapper.deleteByIds(idList) > 0;
    }

    @Override
    public Pagination selectByPage(SysDataDict sysDataDict, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<SysDataDict> list = sysDataDictMapper.selectByPage(sysDataDict, page);
        page.setList(list);
        return page;
    }
}
