package com.jvt.devthread.employee.Activity.Model;

public class AssignedProjectModel {
    String projectId, deadline, priority, assignedBy, projectName, projectDomain, projectStatus;

    public AssignedProjectModel() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDomain() {
        return projectDomain;
    }

    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public AssignedProjectModel(String projectId, String deadline, String priority, String assignedBy, String projectName, String projectDomain, String projectStatus) {
        this.projectId = projectId;
        this.deadline = deadline;
        this.priority = priority;
        this.assignedBy = assignedBy;
        this.projectName = projectName;
        this.projectDomain = projectDomain;
        this.projectStatus = projectStatus;
    }
}
