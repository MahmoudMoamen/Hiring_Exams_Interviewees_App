package com.webApp.controllers;

import com.webApp.requestModels.ExamineeEducationalInfoDetailsRequestModel;
import com.webApp.responses.ErrorMessages;
import com.webApp.responses.ExamineeOperationStatusModel;
import com.webApp.responses.RequestOperationStatus;
import com.webApp.service.FormService;
import com.webApp.shared.ExamineeEducationalInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class ExamineeEducationalInfoController {
    @Autowired
    FormService formService;


    @PostMapping(path = "/EducationalInfo/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public ExamineeOperationStatusModel setEducationalInfo(@PathVariable String id,@RequestBody ExamineeEducationalInfoDetailsRequestModel examineeEducationalInfoDetailsRequestModel){
        if(examineeEducationalInfoDetailsRequestModel== null) throw new NullPointerException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        ExamineeEducationalInfoDto examineeEducationalInfoDto=new ExamineeEducationalInfoDto();
        examineeEducationalInfoDto.setUserId(id);
        examineeEducationalInfoDto.setHigh_school_name(examineeEducationalInfoDetailsRequestModel.getHigh_school_name());
        examineeEducationalInfoDto.setHigh_school_graduation_year(examineeEducationalInfoDetailsRequestModel.getHigh_school_graduation_year());
        examineeEducationalInfoDto.setUniversity_name(examineeEducationalInfoDetailsRequestModel.getUniversity_name());
        examineeEducationalInfoDto.setUniversity_graduation_year(examineeEducationalInfoDetailsRequestModel.getUniversity_graduation_year());
        examineeEducationalInfoDto.setGrade(examineeEducationalInfoDetailsRequestModel.getGrade());
        examineeEducationalInfoDto.setFaculty(examineeEducationalInfoDetailsRequestModel.getFaculty());
        examineeEducationalInfoDto.setMajor(examineeEducationalInfoDetailsRequestModel.getMajor());
        examineeEducationalInfoDto.setAddMoreItems(examineeEducationalInfoDetailsRequestModel.getAddMoreItems());
        ExamineeOperationStatusModel returnValue= new ExamineeOperationStatusModel();
        returnValue.setOperationName(RequestOperationName.SET_EXAMINEE_EDUCATIONAL_DATA.name());
        formService.setEducationalInfo(id,examineeEducationalInfoDto);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        returnValue.setUserId(examineeEducationalInfoDto.getUserId());
        return returnValue;
    }
}
