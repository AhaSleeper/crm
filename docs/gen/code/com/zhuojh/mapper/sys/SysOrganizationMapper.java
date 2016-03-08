package com.zhuojh.mapper.sys;

import com.zhuojh.model.sys.SysOrganization;

public interface SysOrganizationMapper {
    int deleteByPrimaryKey(byte[] organizationId);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(byte[] organizationId);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
}