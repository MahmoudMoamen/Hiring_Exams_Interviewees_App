package com.webApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "textquestionsanswers")
public class TextQuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionHeaderId;

    @Column(nullable = false)
    private String answerEntered;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    public long getQuestionHeaderId() {
        return questionHeaderId;
    }

    public void setQuestionHeaderId(long questionHeaderId) {
        this.questionHeaderId = questionHeaderId;
    }

    public String getAnswerEntered() {
        return answerEntered;
    }

    public void setAnswerEntered(String answerEntered) {
        this.answerEntered = answerEntered;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
