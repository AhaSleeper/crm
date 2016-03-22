package com.zhuojh.vo;

/**
 * Created by snow on 2016/3/15.
 */
public class TreeItem {

    public static final String TYPE_FOLDER = "folder";
    public static final String TYPE_ITEM = "item";

    private String name;
    private String type;
    private AdditionalParameters additionalParameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AdditionalParameters getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(AdditionalParameters additionalParameters) {
        this.additionalParameters = additionalParameters;
    }
}
