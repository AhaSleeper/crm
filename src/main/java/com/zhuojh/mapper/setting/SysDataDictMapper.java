package com.zhuojh.mapper.setting;

import com.zhuojh.model.setting.SysDataDict;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDataDictMapper {
    int deleteByPrimaryKey(String dataDictionaryId);

    int insert(SysDataDict record);

    int insertSelective(SysDataDict record);

    SysDataDict selectByPrimaryKey(String dataDictionaryId);

    int updateByPrimaryKeySelective(SysDataDict record);

    int updateByPrimaryKey(SysDataDict record);

    List<SysDataDict> selectByPage(@Param("sysDataDict") SysDataDict sysDataDict, @Param("page") Pagination page);

    int deleteByIds(List<String> idList);
}