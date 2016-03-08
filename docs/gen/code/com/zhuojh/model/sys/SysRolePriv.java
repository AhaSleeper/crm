package com.zhuojh.model.sys;

public class SysRolePriv {
    private String privRoleId;

    private String roleId;

    private String privId;

    public String getPrivRoleId() {
        return privRoleId;
    }

    public void setPrivRoleId(String privRoleId) {
        this.privRoleId = privRoleId == null ? null : privRoleId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPrivId() {
        return privId;
    }

    public void setPrivId(String privId) {
        this.privId = privId == null ? null : privId.trim();
    }
}