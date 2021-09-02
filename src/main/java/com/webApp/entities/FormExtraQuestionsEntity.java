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

@Entity(name = "extra_questions")
public class FormExtraQuestionsEntity {
    @Id
    @GeneratedValue
    private String user_id;

    @Column(nullable = false)
    private Boolean has_relatives;

    @Type(type = "json")
    @Column(nullable = false, columnDefinition = "jsonb")
    private Map<String, String> recommendation_in_egabifsi = new HashMap<>();

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> reference_check = new HashMap<>();

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Boolean getHas_relatives() {
        return has_relatives;
    }

    public void setHas_relatives(Boolean has_relatives) {
        this.has_relatives = has_relatives;
    }

    public Map<String, String> getRecommendation_in_egabifsi() {
        return recommendation_in_egabifsi;
    }

    public void setRecommendation_in_egabifsi(Map<String, String> recommendation_in_egabifsi) {
        this.recommendation_in_egabifsi = recommendation_in_egabifsi;
    }

    public Map<String, String> getReference_check() {
        return reference_check;
    }

    public void setReference_check(Map<String, String> reference_check) {
        this.reference_check = reference_check;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
