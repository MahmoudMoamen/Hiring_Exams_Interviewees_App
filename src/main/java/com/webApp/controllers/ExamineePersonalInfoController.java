package com.webApp.controllers;

import com.webApp.requestModels.ExamineePersonalDetailsRequestModel;
import com.webApp.responses.ErrorMessages;
import com.webApp.responses.ExamineeOperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.service.FormService;
import com.webApp.shared.ExamineePersonalInfoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class ExamineePersonalInfoController {
    @Autowired
    FormService formService;

    @PostMapping(path="/PersonalInfo",consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public ExamineeOperationStatusModel insertUser(@RequestBody ExamineePersonalDetailsRequestModel examineePersonalDetailsRequestModel){
        if(examineePersonalDetailsRequestModel==null) throw new NullPointerException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        ExamineePersonalInfoDto examineePersonalInfoDto= new ExamineePersonalInfoDto();
        BeanUtils.copyProperties(examineePersonalDetailsRequestModel,examineePersonalInfoDto);
        ExamineeOperationStatusModel returnValue= new ExamineeOperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_PERSONAL_INFO.name());
        formService.insertUser(examineePersonalInfoDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        returnValue.setUserId(examineePersonalInfoDto.getUser_id());
        return returnValue;
    }
}
