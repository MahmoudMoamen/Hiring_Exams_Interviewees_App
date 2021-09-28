package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "examinee_work_experience_info")
public class ExamineeWorkExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(name = "user__id",nullable = false)
    private String userId;

    @Column(name = "fresh_graduate",nullable = false)
    private Boolean freshGraduate;

    @Column(name = "total_years_of_experience",nullable = false)
    private int totalYearsExperience;

    @Column(name = "company_name",nullable = false)
    private String companyName;

    @Column(name = "current_employer",nullable = false)
    private Boolean currentEmployer;

    @Column(name = "date_from",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date from;

    @Column(name = "date_to",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date to;

    @Column(name = "entry_position",nullable = false)
    private String entryPosition;

    @Column(name = "last_position_held",nullable = false)
    private String lastPositionHeld;

    @Column(name = "last_monthly_salary",nullable = false)
    private int lastMonthlySalary;

    @Column(name = "reason_for_leaving",nullable = false)
    private String reasonForLeaving;

    @Column(name = "created_at",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
