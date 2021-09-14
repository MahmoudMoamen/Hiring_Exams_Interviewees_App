package com.webApp.shared;

import java.util.ArrayList;

public class GetQuestionDto {
    private ArrayList<String> topics;
    private ArrayList<Integer> NoOfQuestionsInTopic;

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
}
