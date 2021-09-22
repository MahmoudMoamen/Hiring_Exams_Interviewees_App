package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "questions_headers")
public class QuestionHeadersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 8000)
    private String question;

    @Column(nullable = false)
    private int type_id;

    @Column(nullable = false)
    private int topic_id;

    @Column
    private Boolean result;

    @Column
    private Boolean has_paragraph;

    @Column
    private Long paragraph_id;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Boolean getHas_paragraph() {
        return has_paragraph;
    }

    public void setHas_paragraph(Boolean has_paragraph) {
        this.has_paragraph = has_paragraph;
    }

    public Long getParagraph_id() {
        return paragraph_id;
    }

    public void setParagraph_id(Long paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
