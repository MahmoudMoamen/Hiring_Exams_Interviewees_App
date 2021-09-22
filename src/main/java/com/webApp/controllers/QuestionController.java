package com.webApp.controllers;

import com.webApp.requestModels.GetQuestionDetailsRequestModel;
import com.webApp.responses.OperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.shared.GetQuestionDto;
import com.webApp.shared.QuestionDto;
import com.webApp.requestModels.QuestionsDetailsRequestModel;
import com.webApp.responses.QuestionResponse;
import com.webApp.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping(consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel setQuestion(@RequestBody QuestionsDetailsRequestModel questionsDetailsRequestModel){

        if (questionsDetailsRequestModel.getQuestionHeader() == null && questionsDetailsRequestModel.getParagraphPrompt()==null) throw new NullPointerException("The Object is null");
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(questionsDetailsRequestModel,questionDto);
        OperationStatusModel returnValue=new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_QUESTION.name());
        questionService.setQuestion(questionDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }

    @PostMapping (path = "/get",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public QuestionResponse getQuestions(@RequestBody GetQuestionDetailsRequestModel getQuestionDetailsRequestModel){
        if(getQuestionDetailsRequestModel.getTopics()==null) throw new NullPointerException("The Object is null");
        GetQuestionDto getQuestionDto= new GetQuestionDto();
        BeanUtils.copyProperties(getQuestionDetailsRequestModel,getQuestionDto);
        QuestionResponse returnValue= questionService.getQuestions(getQuestionDto);
        return returnValue;
    }

    @DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel deleteQuestion(@PathVariable long id){
        OperationStatusModel returnValue=new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        questionService.deleteQuestion(id);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
}
