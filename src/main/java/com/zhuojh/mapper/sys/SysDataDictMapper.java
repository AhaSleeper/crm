package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysDataDict;

public interface SysDataDictMapper {
    int deleteByPrimaryKey(String dataDictionaryId);

    int insert(SysDataDict record);

    int insertSelective(SysDataDict record);

    SysDataDict selectByPrimaryKey(String dataDictionaryId);

    int updateByPrimaryKeySelective(SysDataDict record);

    int updateByPrimaryKey(SysDataDict record);
}