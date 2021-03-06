package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "company_job_questions")
public class CompanyJobQuestionsEntity {
    @Id
    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "notice_period",nullable = false)
    private int noticePeriod;

    @Column(name = "expected_monthly_salary",nullable = false)
    private int expectedMonthlySalary;

    @Column(name="heared_about_us",nullable = false)
    private String heardAboutUs;

    @Column(name ="if_others")
    private String ifOthers;

    @Column(name="willing_in_IT_banking_solutions",nullable = false)
    private Boolean willingInItBankingSolutions;

    @Column(name = "willing_traveling_abroad",nullable = false)
    private Boolean willingTravelingAbroad;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
