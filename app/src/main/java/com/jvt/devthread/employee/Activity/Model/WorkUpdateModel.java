package com.jvt.devthread.employee.Activity.Model;

public class WorkUpdateModel {
    String task, noOfHour, noOfPeople, updateTime, updatedBy;

    public WorkUpdateModel() {
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNoOfHour() {
        return noOfHour;
    }

    public void setNoOfHour(String noOfHour) {
        this.noOfHour = noOfHour;
    }

    public String getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(String noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public WorkUpdateModel(String task, String noOfHour, String noOfPeople, String updateTime, String updatedBy) {
        this.task = task;
        this.noOfHour = noOfHour;
        this.noOfPeople = noOfPeople;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
    }
}
