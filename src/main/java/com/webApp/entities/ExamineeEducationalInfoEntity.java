package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Type(type = "json")
    @Column(nullable = false, columnDefinition = "jsonb")
    private Map<String, String> certificate_degree = new HashMap<>();

    @Type(type = "json")
    @Column(nullable = false, columnDefinition = "jsonb")
    private Map<String, String> provider = new HashMap<>();

    @Type(type = "json")
    @Column(nullable = false, columnDefinition = "jsonb")
    private Map<String, String> year = new HashMap<>();

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

    public Map<String, String> getCertificate_degree() {
        return certificate_degree;
    }

    public void setCertificate_degree(Map<String, String> certificate_degree) {
        this.certificate_degree = certificate_degree;
    }

    public Map<String, String> getProvider() {
        return provider;
    }

    public void setProvider(Map<String, String> provider) {
        this.provider = provider;
    }

    public Map<String, String> getYear() {
        return year;
    }

    public void setYear(Map<String, String> year) {
        this.year = year;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
