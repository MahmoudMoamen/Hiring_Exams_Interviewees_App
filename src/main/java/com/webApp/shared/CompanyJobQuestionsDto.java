package com.webApp.shared;

import java.util.Date;

public class CompanyJobQuestionsDto {
    private String userId;
    private int noticePeriod;
    private int expectedMonthlySalary;
    private String heardAboutUs;
    private String ifOthers;
    private Boolean willingInItBankingSolutions;
    private Boolean willingTravelingAbroad;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public int getExpectedMonthlySalary() {
        return expectedMonthlySalary;
    }

    public void setExpectedMonthlySalary(int expectedMonthlySalary) {
        this.expectedMonthlySalary = expectedMonthlySalary;
    }

    public String getHeardAboutUs() {
        return heardAboutUs;
    }

    public void setHeardAboutUs(String heardAboutUs) {
        this.heardAboutUs = heardAboutUs;
    }

    public String getIfOthers() {
        return ifOthers;
    }

    public void setIfOthers(String ifOthers) {
        this.ifOthers = ifOthers;
    }

    public Boolean getWillingInItBankingSolutions() {
        return willingInItBankingSolutions;
    }

    public void setWillingInItBankingSolutions(Boolean willingInItBankingSolutions) {
        this.willingInItBankingSolutions = willingInItBankingSolutions;
    }

    public Boolean getWillingTravelingAbroad() {
        return willingTravelingAbroad;
    }

    public void setWillingTravelingAbroad(Boolean willingTravelingAbroad) {
        this.willingTravelingAbroad = willingTravelingAbroad;
    }
}
