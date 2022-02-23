package com.jvt.devthread.employee.Activity.Model;

public class NotificationModel {
    String notificationHeading, notificationContent, notificationTime;

    public NotificationModel() {
    }

    public String getNotificationHeading() {
        return notificationHeading;
    }

    public void setNotificationHeading(String notificationHeading) {
        this.notificationHeading = notificationHeading;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public NotificationModel(String notificationHeading, String notificationContent, String notificationTime) {
        this.notificationHeading = notificationHeading;
        this.notificationContent = notificationContent;
        this.notificationTime = notificationTime;
    }
}
