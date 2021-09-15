package com.webApp.responses;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionResponse {
    private long id;
    private String questionHeader;
    private int typeId;
    private int topicId;
    private long paragraphId;
    private Boolean hasParagraph;
    private ArrayList<String> choices;
    private String modelAnswer;
    private String paragraphPrompt;
    private ArrayList<String> paragraphQuestions;
    private ArrayList<ArrayList<String>> paragraphChoices;
    private ArrayList<String> paragraphAnswers;
    private ArrayList<String> topics;
    private ArrayList<Integer> NoOfQuestionsInTopic;
    private ArrayList<String> QuestionsReturnedRandomly;
    private ArrayList<ArrayList<String>> RandomQuestionsChoices;
    private ArrayList<Long> RandomQuestionIDs;

    public ArrayList<ArrayList<String>> getRandomQuestionsChoices() {
        return RandomQuestionsChoices;
    }

    public void setRandomQuestionsChoices(ArrayList<ArrayList<String>> randomQuestionsChoices) {
        RandomQuestionsChoices = randomQuestionsChoices;
    }

    public ArrayList<Long> getRandomQuestionIDs() {
        return RandomQuestionIDs;
    }

    public void setRandomQuestionIDs(ArrayList<Long> randomQuestionIDs) {
        RandomQuestionIDs = randomQuestionIDs;
    }

    public ArrayList<String> getQuestionsReturnedRandomly() {
        return QuestionsReturnedRandomly;
    }

    public void setQuestionsReturnedRandomly( ArrayList<String> questionsReturnedRandomly) {
        QuestionsReturnedRandomly = questionsReturnedRandomly;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public ArrayList<Integer> getNoOfQuestionsInTopic() {
        return NoOfQuestionsInTopic;
    }

    public void setNoOfQuestionsInTopic(ArrayList<Integer> noOfQuestionsInTopic) {
        NoOfQuestionsInTopic = noOfQuestionsInTopic;
    }

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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
