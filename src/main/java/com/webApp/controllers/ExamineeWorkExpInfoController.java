package com.webApp.controllers;

import com.webApp.requestModels.ExamineeWorkExpDetailsRequestModel;
import com.webApp.responses.ErrorMessages;
import com.webApp.responses.ExamineeOperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.service.FormService;
import com.webApp.shared.ExamineeWorkExpDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class ExamineeWorkExpInfoController {
    @Autowired
    FormService formService;

    @PostMapping(path = "/WorkExperienceInfo/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public ExamineeOperationStatusModel setWorkExperienceData(@PathVariable String id, @RequestBody ExamineeWorkExpDetailsRequestModel examineeWorkExpDetailsRequestModel){
        if(examineeWorkExpDetailsRequestModel==null) throw new NullPointerException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        ExamineeWorkExpDto examineeWorkExpDto= new ExamineeWorkExpDto();
        BeanUtils.copyProperties(examineeWorkExpDetailsRequestModel,examineeWorkExpDto);
        examineeWorkExpDto.setUserId(id);
        ExamineeOperationStatusModel returnValue = new ExamineeOperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_EXAMINEE_WORK_EXPERIENCE_DATA.name());
        formService.setWorkExperienceInfo(id,examineeWorkExpDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        returnValue.setUserId(examineeWorkExpDto.getUserId());
        return returnValue;
    }
}
