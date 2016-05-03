package com.zhuojh.model.customer;

import java.util.Date;

public class ContactHistory {
    private String contactHistId;

    private String customerId;

    private String contactBrief;

    private String contactContent;

    private String contactCustomer;

    private String contactPerson;

    private Integer contactType;

    private String contactWay;

    private String ourPerson;

    private String address;

    private Date noteDate;

    private String noteBy;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private String remark;

    public String getContactHistId() {
        return contactHistId;
    }

    public void setContactHistId(String contactHistId) {
        this.contactHistId = contactHistId == null ? null : contactHistId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getContactContent() {
        return contactContent;
    }

    public void setContactContent(String contactContent) {
        this.contactContent = contactContent == null ? null : contactContent.trim();
    }

    public String getContactCustomer() {
        return contactCustomer;
    }

    public void setContactCustomer(String contactCustomer) {
        this.contactCustomer = contactCustomer == null ? null : contactCustomer.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public String getOurPerson() {
        return ourPerson;
    }

    public void setOurPerson(String ourPerson) {
        this.ourPerson = ourPerson == null ? null : ourPerson.trim();
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteBy() {
        return noteBy;
    }

    public void setNoteBy(String noteBy) {
        this.noteBy = noteBy == null ? null : noteBy.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getContactBrief() {
        return contactBrief;
    }

    public void setContactBrief(String contactBrief) {
        this.contactBrief = contactBrief;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}