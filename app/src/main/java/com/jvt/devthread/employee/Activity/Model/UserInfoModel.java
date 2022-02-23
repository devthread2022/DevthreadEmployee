package com.jvt.devthread.employee.Activity.Model;

public class UserInfoModel {
    String uid, name, empId, status, profile, gitHub, education, address, email, phone;

    public UserInfoModel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserInfoModel(String uid, String name, String empId, String status, String profile, String gitHub, String education, String address, String email, String phone) {
        this.uid = uid;
        this.name = name;
        this.empId = empId;
        this.status = status;
        this.profile = profile;
        this.gitHub = gitHub;
        this.education = education;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
