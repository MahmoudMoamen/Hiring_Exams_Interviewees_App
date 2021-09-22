package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "examinees")
public class ExamineesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column()
    private String status;

    @Column()
    private String overall_score;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(String overall_score) {
        this.overall_score = overall_score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
