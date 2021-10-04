package com.webApp.requestModels;

import java.util.ArrayList;

public class FormExtraQuestionsRequestModel {
    private Boolean hasRelatives;
    private ArrayList<ArrayList<String>> recommendation;
    private ArrayList<ArrayList<String>> referenceCheck;

    public Boolean getHasRelatives() {
        return hasRelatives;
    }

    public void setHasRelatives(Boolean hasRelatives) {
        this.hasRelatives = hasRelatives;
    }

    public ArrayList<ArrayList<String>> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(ArrayList<ArrayList<String>> recommendation) {
        this.recommendation = recommendation;
    }

    public ArrayList<ArrayList<String>> getReferenceCheck() {
        return referenceCheck;
    }

    public void setReferenceCheck(ArrayList<ArrayList<String>> referenceCheck) {
        this.referenceCheck = referenceCheck;
    }
}
