package com.webApp.controllers;

import com.webApp.requestModels.FormExtraQuestionsRequestModel;
import com.webApp.responses.ErrorMessages;
import com.webApp.responses.ExamineeOperationStatusModel;
import com.webApp.responses.OperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.service.FormService;
import com.webApp.shared.FormExtraQuestionsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class ExtraQuestionsController {
    @Autowired
    FormService formService;

    @PostMapping(path="/ExtraQuestions/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel setFormExtraAnswers(@PathVariable String id, @RequestBody FormExtraQuestionsRequestModel formExtraQuestionsRequestModel){
        if(formExtraQuestionsRequestModel==null) throw new NullPointerException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        FormExtraQuestionsDto formExtraQuestionsDto=new FormExtraQuestionsDto();
        BeanUtils.copyProperties(formExtraQuestionsRequestModel,formExtraQuestionsDto);
        formExtraQuestionsDto.setUserId(id);
        OperationStatusModel returnValue=new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_EXTRA_ANSWERS.name());
        formService.setFormExtraInfo(id,formExtraQuestionsDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
}
