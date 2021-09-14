package com.webApp.requestModels;

import java.util.ArrayList;

public class GetQuestionDetailsRequestModel {
    private ArrayList<String> topics;
    private ArrayList<Integer> noOfQuestionsInTopic;

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public ArrayList<Integer> getNoOfQuestionsInTopic() {
        return noOfQuestionsInTopic;
    }

    public void setNoOfQuestionsInTopic(ArrayList<Integer> noOfQuestionsInTopic) {
        this.noOfQuestionsInTopic = noOfQuestionsInTopic;
    }
}
