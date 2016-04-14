package com.zhuojh.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snow on 2016/3/15.
 */
public class AdditionalParameters {
    /**
     * 子节点列表
     */
    private List<TreeItem> children = new ArrayList<TreeItem>();

    /**
     * 节点id
     */
    private String id;

    /**
     * 父节点id
     */
    private String pid;

    /**
     * 父节点名称
     */
    private String pName;

    private Integer menuType;

    private String menuTypeStr;

    /**
     * 图标
     */
    private String icon;

    private String url;

    private boolean itemSelected;

    private Integer seq;

    public List<TreeItem> getChildren() {
        return children;
    }

    public void setChildren(List<TreeItem> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getMenuTypeStr() {
        return menuTypeStr;
    }

    public void setMenuTypeStr(String menuTypeStr) {
        this.menuTypeStr = menuTypeStr;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
}
