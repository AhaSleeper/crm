package com.zhuojh.model.sys;

import org.apache.ibatis.type.Alias;

@Alias("menu")
public class SysMenu {
    private String menuId;

    private String pid;

    private String pName;
    private String menuName;

    private String menuUrl;

    private Integer menuType;

    private String menuIcon;

    private Integer seq;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getMenuTypeStr(){
        if(menuType!=null){
            if(menuType.equals(3)){
                return "系统";
            } else if(menuType.equals(2)){
                return "模块";
            } else if(menuType.equals(1)){
                return "菜单";
            }
        }
        return null;
    }
}