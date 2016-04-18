package com.zhuojh.model.sys;

import org.apache.ibatis.type.Alias;

@Alias("dataDict")
public class SysDataDict {
    private String dataDictionaryId;

    private Integer code;

    private String type;

    private String item;

    private String value;

    private Boolean isEditable;

    public String getDataDictionaryId() {
        return dataDictionaryId;
    }

    public void setDataDictionaryId(String dataDictionaryId) {
        this.dataDictionaryId = dataDictionaryId == null ? null : dataDictionaryId.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }
}