package com.zhuojh.model.services;

import java.util.Date;

public class Services {
    private String serviceId;

    private Integer code;

    private String serviceType;

    private String brief;

    private Integer state;

    private String customer;

    private String serviceRequirement;

    private String createBy;

    private Date createDate;

    private String assignTo;

    private String assignToName;

    private Date assignDate;

    private String serviceHandling;

    private String handleBy;

    private Date handleDate;

    private String handleResult;

    private String satisfyRate;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getServiceRequirement() {
        return serviceRequirement;
    }

    public void setServiceRequirement(String serviceRequirement) {
        this.serviceRequirement = serviceRequirement == null ? null : serviceRequirement.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo == null ? null : assignTo.trim();
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public String getServiceHandling() {
        return serviceHandling;
    }

    public void setServiceHandling(String serviceHandling) {
        this.serviceHandling = serviceHandling == null ? null : serviceHandling.trim();
    }

    public String getHandleBy() {
        return handleBy;
    }

    public void setHandleBy(String handleBy) {
        this.handleBy = handleBy == null ? null : handleBy.trim();
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    public String getSatisfyRate() {
        return satisfyRate;
    }

    public void setSatisfyRate(String satisfyRate) {
        this.satisfyRate = satisfyRate == null ? null : satisfyRate.trim();
    }

    public String getAssignToName() {
        return assignToName;
    }

    public void setAssignToName(String assignToName) {
        this.assignToName = assignToName;
    }
}