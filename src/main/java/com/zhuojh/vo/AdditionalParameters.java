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
     * 图标
     */
    private String icon;

    private String url;

    private boolean itemSelected;

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
}
