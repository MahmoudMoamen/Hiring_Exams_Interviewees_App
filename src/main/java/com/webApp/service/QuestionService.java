package com.webApp.service;

import com.webApp.responses.OperationStatusModel;
import com.webApp.shared.GetQuestionDto;
import com.webApp.shared.QuestionDto;
import com.webApp.responses.QuestionResponse;

public interface QuestionService {
    void setQuestion(QuestionDto questionDto);
    QuestionResponse getQuestions(GetQuestionDto getQuestionDto);
    void shufflingQuestions(long requestedNoOfQuestions, long noOfTypes);
    void deleteQuestion(long id);
}
