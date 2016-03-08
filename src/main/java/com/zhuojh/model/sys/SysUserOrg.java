package com.zhuojh.model.sys;

public class SysUserOrg {
    private String userOrgId;

    private String userId;

    private byte[] organiztionId;

    public String getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId == null ? null : userOrgId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public byte[] getOrganiztionId() {
        return organiztionId;
    }

    public void setOrganiztionId(byte[] organiztionId) {
        this.organiztionId = organiztionId;
    }
}