package com.jvt.devthread.employee.Activity.Model;

public class TicketModel {
    String userId, ticketId, orderId, severity, description, userEmail, userMobile, userName, ticketTime,ticketStatus;

    public TicketModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(String ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public TicketModel(String userId, String ticketId, String orderId, String severity, String description, String userEmail, String userMobile, String userName, String ticketTime, String ticketStatus) {
        this.userId = userId;
        this.ticketId = ticketId;
        this.orderId = orderId;
        this.severity = severity;
        this.description = description;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userName = userName;
        this.ticketTime = ticketTime;
        this.ticketStatus = ticketStatus;
    }
}
