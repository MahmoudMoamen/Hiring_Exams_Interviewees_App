package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "examinee_work_experience_info")
public class ExamineeWorkExperienceEntity {
    @Id
    @GeneratedValue
    private long seq;

    @Column(nullable = false)
    private String user__id;

    @Column(nullable = false)
    private Boolean fresh_graduate;

    @Column(nullable = false)
    private int total_years_of_experience;

    @Column(nullable = false)
    private String company_name;

    @Column(nullable = false)
    private Boolean current_employer;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date from;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date to;

    @Column(nullable = false)
    private String entry_position;

    @Column(nullable = false)
    private String last_position_held;

    @Column(nullable = false)
    private int last_monthly_salary;

    @Column(nullable = false)
    private String reason_for_leaving;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getUser__id() {
        return user__id;
    }

    public void setUser__id(String user__id) {
        this.user__id = user__id;
    }

    public Boolean getFresh_graduate() {
        return fresh_graduate;
    }

    public void setFresh_graduate(Boolean fresh_graduate) {
        this.fresh_graduate = fresh_graduate;
    }

    public int getTotal_years_of_experience() {
        return total_years_of_experience;
    }

    public void setTotal_years_of_experience(int total_years_of_experience) {
        this.total_years_of_experience = total_years_of_experience;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Boolean getCurrent_employer() {
        return current_employer;
    }

    public void setCurrent_employer(Boolean current_employer) {
        this.current_employer = current_employer;
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

    public String getEntry_position() {
        return entry_position;
    }

    public void setEntry_position(String entry_position) {
        this.entry_position = entry_position;
    }

    public String getLast_position_held() {
        return last_position_held;
    }

    public void setLast_position_held(String last_position_held) {
        this.last_position_held = last_position_held;
    }

    public int getLast_monthly_salary() {
        return last_monthly_salary;
    }

    public void setLast_monthly_salary(int last_monthly_salary) {
        this.last_monthly_salary = last_monthly_salary;
    }

    public String getReason_for_leaving() {
        return reason_for_leaving;
    }

    public void setReason_for_leaving(String reason_for_leaving) {
        this.reason_for_leaving = reason_for_leaving;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
