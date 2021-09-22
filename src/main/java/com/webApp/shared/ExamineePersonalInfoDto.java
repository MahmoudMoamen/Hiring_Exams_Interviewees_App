package com.webApp.shared;

import java.util.Date;

public class ExamineePersonalInfoDto {
    private String user_id;
    private String applicant_name;
    private String address;
    private String position_applied_for;
    private String email;
    private String marital_status;
    private String military_status;
    private Date date;
    private String city;
    private String technology;
    private String mobile;
    private int number_of_dependents;
    private Date if_postponed_date;
    private Date created_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition_applied_for() {
        return position_applied_for;
    }

    public void setPosition_applied_for(String position_applied_for) {
        this.position_applied_for = position_applied_for;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getMilitary_status() {
        return military_status;
    }

    public void setMilitary_status(String military_status) {
        this.military_status = military_status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getNumber_of_dependents() {
        return number_of_dependents;
    }

    public void setNumber_of_dependents(int number_of_dependents) {
        this.number_of_dependents = number_of_dependents;
    }

    public Date getIf_postponed_date() {
        return if_postponed_date;
    }

    public void setIf_postponed_date(Date if_postponed_date) {
        this.if_postponed_date = if_postponed_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
