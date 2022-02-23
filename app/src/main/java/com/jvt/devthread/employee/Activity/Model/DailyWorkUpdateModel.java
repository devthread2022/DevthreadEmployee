package com.jvt.devthread.employee.Activity.Model;

public class DailyWorkUpdateModel {
    String projectName, workDone, timeTaken, feedback, empId, empName, workId, workDate;
    Integer loc;

    public DailyWorkUpdateModel() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public DailyWorkUpdateModel(String projectName, String workDone, String timeTaken, String feedback, String empId, String empName, String workId, String workDate, Integer loc) {
        this.projectName = projectName;
        this.workDone = workDone;
        this.timeTaken = timeTaken;
        this.feedback = feedback;
        this.empId = empId;
        this.empName = empName;
        this.workId = workId;
        this.workDate = workDate;
        this.loc = loc;
    }
}
