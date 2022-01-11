package com.jvt.devthread.employee.Activity.Model;

public class AssignedDemoModel {
    String customerName, customerEmail,customerMobile, requestId, meetingTime,meetingDate,
            referenceApp, ideaType, selectedProduct,demoStatus,address,demoType,customerUid;

    public AssignedDemoModel() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getReferenceApp() {
        return referenceApp;
    }

    public void setReferenceApp(String referenceApp) {
        this.referenceApp = referenceApp;
    }

    public String getIdeaType() {
        return ideaType;
    }

    public void setIdeaType(String ideaType) {
        this.ideaType = ideaType;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getDemoStatus() {
        return demoStatus;
    }

    public void setDemoStatus(String demoStatus) {
        this.demoStatus = demoStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDemoType() {
        return demoType;
    }

    public void setDemoType(String demoType) {
        this.demoType = demoType;
    }

    public String getCustomerUid() {
        return customerUid;
    }

    public void setCustomerUid(String customerUid) {
        this.customerUid = customerUid;
    }

    public AssignedDemoModel(String customerName, String customerEmail, String customerMobile, String requestId, String meetingTime, String meetingDate, String referenceApp, String ideaType, String selectedProduct, String demoStatus, String address, String demoType, String customerUid) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobile = customerMobile;
        this.requestId = requestId;
        this.meetingTime = meetingTime;
        this.meetingDate = meetingDate;
        this.referenceApp = referenceApp;
        this.ideaType = ideaType;
        this.selectedProduct = selectedProduct;
        this.demoStatus = demoStatus;
        this.address = address;
        this.demoType = demoType;
        this.customerUid = customerUid;
    }
}
