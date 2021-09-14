package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "paragraphs")
public class ParagraphsEntity {
    @Id
    @GeneratedValue
    private Long paragraph_id;

    @Column(nullable = false,length = 8000)
    private String paragraph;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public Long getParagraph_id() {
        return paragraph_id;
    }

    public void setParagraph_id(Long paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
