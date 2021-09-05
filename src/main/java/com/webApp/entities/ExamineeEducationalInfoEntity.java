package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "examinee_educational_info")
public class ExamineeEducationalInfoEntity {
    @Id
    @GeneratedValue
    private String id_of_user;

    @Column(nullable = false)
    private String high_school_name;

    @Column(nullable = false)
    private int high_school_graduation_year;

    @Column(nullable = false)
    private String university_name;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private int university_graduation_year;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public String getId_of_user() {
        return id_of_user;
    }

    public void setId_of_user(String id_of_user) {
        this.id_of_user = id_of_user;
    }

    public String getHigh_school_name() {
        return high_school_name;
    }

    public void setHigh_school_name(String high_school_name) {
        this.high_school_name = high_school_name;
    }

    public int getHigh_school_graduation_year() {
        return high_school_graduation_year;
    }

    public void setHigh_school_graduation_year(int high_school_graduation_year) {
        this.high_school_graduation_year = high_school_graduation_year;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getUniversity_graduation_year() {
        return university_graduation_year;
    }

    public void setUniversity_graduation_year(int university_graduation_year) {
        this.university_graduation_year = university_graduation_year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
