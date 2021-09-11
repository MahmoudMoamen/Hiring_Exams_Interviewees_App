package com.webApp.requestModels;

import java.util.ArrayList;

public class QuestionsDetailsRequestModel {
    private String questionHeader;
    private int typeId;
    private String topic;
    private long paragraphId;
    private Boolean hasParagraph;
    private ArrayList<String> choices;
    private String modelAnswer;
    private String paragraphPrompt;
    private ArrayList<String> paragraphQuestions;
    private ArrayList<ArrayList<String>> paragraphChoices;
    private ArrayList<String> paragraphAnswers;

    public ArrayList<String> getParagraphAnswers() {
        return paragraphAnswers;
    }

    public void setParagraphAnswers(ArrayList<String> paragraphAnswers) {
        this.paragraphAnswers = paragraphAnswers;
    }

    public ArrayList<ArrayList<String>> getParagraphChoices() {
        return paragraphChoices;
    }

    public void setParagraphChoices(ArrayList<ArrayList<String>> paragraphChoices) {
        this.paragraphChoices = paragraphChoices;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getParagraphPrompt() {
        return paragraphPrompt;
    }

    public void setParagraphPrompt(String paragraphPrompt) {
        this.paragraphPrompt = paragraphPrompt;
    }

    public ArrayList<String> getParagraphQuestions() {
        return paragraphQuestions;
    }

    public void setParagraphQuestions(ArrayList<String> paragraphQuestions) {
        this.paragraphQuestions = paragraphQuestions;
    }

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

    public long getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(long paragraphId) {
        this.paragraphId = paragraphId;
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
