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

    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }
}
