package com.jvt.devthread.employee.Activity.Model;

public class HolidayCalenderModel {
    String holidayName, holidayDate, holidayId;

    public HolidayCalenderModel() {
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(String holidayId) {
        this.holidayId = holidayId;
    }

    public HolidayCalenderModel(String holidayName, String holidayDate, String holidayId) {
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.holidayId = holidayId;
    }
}
