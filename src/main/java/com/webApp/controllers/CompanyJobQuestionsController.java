package com.webApp.controllers;

import com.webApp.requestModels.CompanyJobQuestionsRequestModel;
import com.webApp.responses.ErrorMessages;
import com.webApp.responses.ExamineeOperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.service.FormService;
import com.webApp.shared.CompanyJobQuestionsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class CompanyJobQuestionsController {
    @Autowired
    FormService formService;

    @PostMapping(path = "/JobQuestions/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public ExamineeOperationStatusModel setJobAnswers(@PathVariable String id, @RequestBody CompanyJobQuestionsRequestModel companyJobQuestionsRequestModel){
        if(companyJobQuestionsRequestModel==null) throw new NullPointerException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        CompanyJobQuestionsDto companyJobQuestionsDto=new CompanyJobQuestionsDto();
        BeanUtils.copyProperties(companyJobQuestionsRequestModel,companyJobQuestionsDto);
        companyJobQuestionsDto.setUserId(id);
        ExamineeOperationStatusModel returnValue=new ExamineeOperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_JOB_ANSWERS.name());
        formService.setJobQuestionAns(id,companyJobQuestionsDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        returnValue.setUserId(companyJobQuestionsDto.getUserId());
        return returnValue;
    }
}
