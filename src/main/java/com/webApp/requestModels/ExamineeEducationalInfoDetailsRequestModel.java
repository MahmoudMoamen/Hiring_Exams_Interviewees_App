package com.webApp.requestModels;

import com.webApp.entities.EducationalExtraInfoEntity;

import java.util.ArrayList;
import java.util.List;

public class ExamineeEducationalInfoDetailsRequestModel {
    private String high_school_name;
    private int high_school_graduation_year;
    private String university_name;
    private String major;
    private String grade;
    private int university_graduation_year;
    private String faculty;
    private ArrayList<ArrayList<String>> AddMoreItems;


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

    public ArrayList<ArrayList<String>> getAddMoreItems() {
        return AddMoreItems;
    }

    public void setAddMoreItems(ArrayList<ArrayList<String>> addMoreItems) {
        AddMoreItems = addMoreItems;
    }
}
