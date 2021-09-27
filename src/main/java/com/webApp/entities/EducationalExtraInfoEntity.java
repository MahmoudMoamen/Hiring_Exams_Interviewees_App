package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "educational_extra_info")
public class EducationalExtraInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(nullable = false)
    private String certificate_degree;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

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

    public String getCertificate_degree() {
        return certificate_degree;
    }

    public void setCertificate_degree(String certificate_degree) {
        this.certificate_degree = certificate_degree;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
