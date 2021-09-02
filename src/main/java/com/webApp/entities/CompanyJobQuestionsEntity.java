package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "company_job_questions")
public class CompanyJobQuestionsEntity {
    @Id
    @GeneratedValue
    private String user_id;

    @Column(nullable = false)
    private int notice_period;

    @Column(nullable = false)
    private int expected_monthly_salary;

    @Column(nullable = false)
    private String heared_about_us;

    @Column
    private String if_others;

    @Column(nullable = false)
    private Boolean willing_in_IT_banking_solutions;

    @Column(nullable = false)
    private Boolean willing_traveling_abroad;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getNotice_period() {
        return notice_period;
    }

    public void setNotice_period(int notice_period) {
        this.notice_period = notice_period;
    }

    public int getExpected_monthly_salary() {
        return expected_monthly_salary;
    }

    public void setExpected_monthly_salary(int expected_monthly_salary) {
        this.expected_monthly_salary = expected_monthly_salary;
    }

    public String getHeared_about_us() {
        return heared_about_us;
    }

    public void setHeared_about_us(String heared_about_us) {
        this.heared_about_us = heared_about_us;
    }

    public String getIf_others() {
        return if_others;
    }

    public void setIf_others(String if_others) {
        this.if_others = if_others;
    }

    public Boolean getWilling_in_IT_banking_solutions() {
        return willing_in_IT_banking_solutions;
    }

    public void setWilling_in_IT_banking_solutions(Boolean willing_in_IT_banking_solutions) {
        this.willing_in_IT_banking_solutions = willing_in_IT_banking_solutions;
    }

    public Boolean getWilling_traveling_abroad() {
        return willing_traveling_abroad;
    }

    public void setWilling_traveling_abroad(Boolean willing_traveling_abroad) {
        this.willing_traveling_abroad = willing_traveling_abroad;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
