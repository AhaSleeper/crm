package com.zhuojh.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by snow on 2016/3/14.
 */
public class TreeVo {
    public static final String TYPE_FOLDER = "folder";
    public static final String TYPE_ITEM = "item";
    private String text;
    private String type = "item";
    private Map<String,Object> attr;
    private List<TreeVo> children;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    public List<TreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVo> children) {
        this.children = children;
    }
}
