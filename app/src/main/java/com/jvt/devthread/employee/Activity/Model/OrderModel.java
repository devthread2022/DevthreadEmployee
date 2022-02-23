package com.jvt.devthread.employee.Activity.Model;

public class OrderModel {
    String orderId,orderStatus,assignedTo,priority,note,assignedBy,assignedDate,dueDate,productName,productDomain,assigneeContact
            ,productId,domainTag,productPlatform,productType,unselectedFeatures;

    public OrderModel() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDomain() {
        return productDomain;
    }

    public void setProductDomain(String productDomain) {
        this.productDomain = productDomain;
    }

    public String getAssigneeContact() {
        return assigneeContact;
    }

    public void setAssigneeContact(String assigneeContact) {
        this.assigneeContact = assigneeContact;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDomainTag() {
        return domainTag;
    }

    public void setDomainTag(String domainTag) {
        this.domainTag = domainTag;
    }

    public String getProductPlatform() {
        return productPlatform;
    }

    public void setProductPlatform(String productPlatform) {
        this.productPlatform = productPlatform;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUnselectedFeatures() {
        return unselectedFeatures;
    }

    public void setUnselectedFeatures(String unselectedFeatures) {
        this.unselectedFeatures = unselectedFeatures;
    }

    public OrderModel(String orderId, String orderStatus, String assignedTo, String priority, String note, String assignedBy, String assignedDate, String dueDate, String productName, String productDomain, String assigneeContact, String productId, String domainTag, String productPlatform, String productType, String unselectedFeatures) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.note = note;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
        this.dueDate = dueDate;
        this.productName = productName;
        this.productDomain = productDomain;
        this.assigneeContact = assigneeContact;
        this.productId = productId;
        this.domainTag = domainTag;
        this.productPlatform = productPlatform;
        this.productType = productType;
        this.unselectedFeatures = unselectedFeatures;
    }
}
