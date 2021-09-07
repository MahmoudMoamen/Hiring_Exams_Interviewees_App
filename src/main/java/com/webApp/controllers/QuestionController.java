package com.webApp.controllers;

import com.webApp.QuestionDto;
import com.webApp.requestModels.AdminDetailsRequestModel;
import com.webApp.requestModels.QuestionsDetailsRequestModel;
import com.webApp.responses.AdminResponse;
import com.webApp.responses.QuestionResponse;
import com.webApp.service.AdminService;
import com.webApp.service.QuestionService;
import com.webApp.shared.AdminDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping(consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public QuestionResponse setQuestion(@RequestBody QuestionsDetailsRequestModel questionsDetailsRequestModel){

        if (questionsDetailsRequestModel.getQuestionHeader().isEmpty()) throw new NullPointerException("The Object is null");
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(questionsDetailsRequestModel,questionDto);

        QuestionResponse returnValue=questionService.setQuestion(questionDto);

        return returnValue;
    }
}
