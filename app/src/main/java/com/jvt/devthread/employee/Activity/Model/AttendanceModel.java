package com.jvt.devthread.employee.Activity.Model;

public class AttendanceModel {
    String date, workingHr, ableToWork, empLocation, attendanceId, approvedBy, empId, empName, attendanceStatus;

    public AttendanceModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorkingHr() {
        return workingHr;
    }

    public void setWorkingHr(String workingHr) {
        this.workingHr = workingHr;
    }

    public String getAbleToWork() {
        return ableToWork;
    }

    public void setAbleToWork(String ableToWork) {
        this.ableToWork = ableToWork;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
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

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public AttendanceModel(String date, String workingHr, String ableToWork, String empLocation, String attendanceId, String approvedBy, String empId, String empName, String attendanceStatus) {
        this.date = date;
        this.workingHr = workingHr;
        this.ableToWork = ableToWork;
        this.empLocation = empLocation;
        this.attendanceId = attendanceId;
        this.approvedBy = approvedBy;
        this.empId = empId;
        this.empName = empName;
        this.attendanceStatus = attendanceStatus;
    }
}
