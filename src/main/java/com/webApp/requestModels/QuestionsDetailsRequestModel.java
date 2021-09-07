package com.webApp.requestModels;

import java.util.ArrayList;

public class QuestionsDetailsRequestModel {
    private String questionHeader;
    private int typeId;
    private String topic;
    private long paragraghId;
    private Boolean hasParagraph;
    private ArrayList<String> choices;
    private String modelAnswer;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopicId(String topic) {
        this.topic = topic;
    }

    public long getParagraghId() {
        return paragraghId;
    }

    public void setParagraghId(long paragraghId) {
        this.paragraghId = paragraghId;
    }

    public Boolean getHasParagraph() {
        return hasParagraph;
    }

    public void setHasParagraph(Boolean hasParagraph) {
        this.hasParagraph = hasParagraph;
    }

    public String getQuestionHeader() {
        return questionHeader;
    }

    public void setQuestionHeader(String questionHeader) {
        this.questionHeader = questionHeader;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public String getModelAnswer() {
        return modelAnswer;
    }

    public void setModelAnswer(String modelAnswer) {
        this.modelAnswer = modelAnswer;
    }
}
