package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "extra_questions")
public class FormExtraQuestionsEntity {
    @Id
    @GeneratedValue
    private String user_id;

    @Column(nullable = false)
    private Boolean has_relatives;

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
