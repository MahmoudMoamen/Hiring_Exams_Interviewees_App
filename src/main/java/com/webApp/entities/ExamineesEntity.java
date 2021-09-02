package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "examinees")
public class ExamineesEntity {
    @Id
    @GeneratedValue
    private String user_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String encrypted_password;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;
}
