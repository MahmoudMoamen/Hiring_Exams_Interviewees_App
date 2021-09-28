package com.webApp.shared;

import java.util.Date;

public class ExamineeWorkExpDto {
    private String userId;
    private Boolean freshGraduate;
    private int totalYearsExperience;
    private String companyName;
    private Boolean currentEmployer;
    private Date from;
    private Date to;
    private String entryPosition;
    private String lastPositionHeld;
    private int lastMonthlySalary;
    private String reasonForLeaving;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getFreshGraduate() {
        return freshGraduate;
    }

    public void setFreshGraduate(Boolean freshGraduate) {
        this.freshGraduate = freshGraduate;
    }

    public int getTotalYearsExperience() {
        return totalYearsExperience;
    }

    public void setTotalYearsExperience(int totalYearsExperience) {
        this.totalYearsExperience = totalYearsExperience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(Boolean currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getEntryPosition() {
        return entryPosition;
    }

    public void setEntryPosition(String entryPosition) {
        this.entryPosition = entryPosition;
    }

    public String getLastPositionHeld() {
        return lastPositionHeld;
    }

    public void setLastPositionHeld(String lastPositionHeld) {
        this.lastPositionHeld = lastPositionHeld;
    }

    public int getLastMonthlySalary() {
        return lastMonthlySalary;
    }

    public void setLastMonthlySalary(int lastMonthlySalary) {
        this.lastMonthlySalary = lastMonthlySalary;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

}
