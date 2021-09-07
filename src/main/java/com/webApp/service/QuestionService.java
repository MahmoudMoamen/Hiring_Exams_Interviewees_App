package com.webApp.service;

import com.webApp.QuestionDto;
import com.webApp.responses.QuestionResponse;

public interface QuestionService {
    QuestionResponse setQuestion(QuestionDto questionDto);
}
