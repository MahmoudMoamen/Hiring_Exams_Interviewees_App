package com.webApp.service;

import com.webApp.shared.GetQuestionDto;
import com.webApp.shared.QuestionDto;
import com.webApp.responses.QuestionResponse;

public interface QuestionService {
    QuestionResponse setQuestion(QuestionDto questionDto);
    QuestionResponse getQuestions(GetQuestionDto getQuestionDto);
}
