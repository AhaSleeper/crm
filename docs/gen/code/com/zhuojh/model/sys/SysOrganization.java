package com.zhuojh.model.sys;

public class SysOrganization {
    private byte[] organizationId;

    private String organizationName;

    private String organizationNum;

    private String organizationDesc;

    public byte[] getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(byte[] organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum == null ? null : organizationNum.trim();
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc == null ? null : organizationDesc.trim();
    }
}