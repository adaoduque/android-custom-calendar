package com.example.adusilne.calendar;

/**
 * Created by adao on 8/10/17.
 */

public class DaysList {
    private String day;
    private String month;
    private String year;
    private String dayFull;
    private String monthFull;
    private String fullDate;

    public DaysList(String day, String month, String year, String dayFull, String monthFull, String fullDate) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayFull = dayFull;
        this.monthFull = monthFull;
        this.fullDate = fullDate;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getDayFull() {
        return dayFull;
    }

    public String getMonthFull() {
        return monthFull;
    }

    public String getFullDate() {
        return fullDate;
    }
}

