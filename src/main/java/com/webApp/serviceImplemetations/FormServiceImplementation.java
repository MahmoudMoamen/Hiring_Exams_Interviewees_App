package com.webApp.serviceImplemetations;

import com.webApp.entities.*;
import com.webApp.exceptions.ExamineeServiceException;
import com.webApp.repositories.EducationalExtraInfoRepository;
import com.webApp.repositories.ExamineeEducationalInfoRepository;
import com.webApp.repositories.ExamineePersonalInfoRepository;
import com.webApp.repositories.ExamineeRepository;
import com.webApp.responses.ErrorMessages;
import com.webApp.service.FormService;
import com.webApp.shared.ExamineeEducationalInfoDto;
import com.webApp.shared.ExamineePersonalInfoDto;
import com.webApp.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class FormServiceImplementation implements FormService {
    @Autowired
    ExamineeRepository examineeRepository;
    @Autowired
    ExamineePersonalInfoRepository examineePersonalInfoRepository;

    @Autowired
    ExamineeEducationalInfoRepository examineeEducationalInfoRepository;

    @Autowired
    EducationalExtraInfoRepository educationalExtraInfoRepository;


    @Override
    public void insertUser(ExamineePersonalInfoDto examineePersonalInfoDto) {
        ExamineePersonalInfoEntity examineePersonalInfoEntity = new ExamineePersonalInfoEntity();
//        ExamineesEntity examineesEntity= new ExamineesEntity();
        examineePersonalInfoDto.setCreated_at(new Date(System.currentTimeMillis()));
        examineePersonalInfoDto.setUser_id(Utils.generateUserID());
//        examineesEntity.setUser_id(examineePersonalInfoDto.getUser_id());
//        examineesEntity.setUsername(examineePersonalInfoDto.getApplicant_name());
//        examineesEntity.setEmail(examineePersonalInfoDto.getEmail());
        BeanUtils.copyProperties(examineePersonalInfoDto, examineePersonalInfoEntity);
        examineePersonalInfoRepository.save(examineePersonalInfoEntity);
    }

    @Override
    public void updateUser(String id, ExamineePersonalInfoDto examineePersonalInfoDto) {
        ExamineePersonalInfoEntity examineePersonalInfoEntity = examineePersonalInfoRepository.getOne(id);
        if (examineePersonalInfoEntity == null)
            throw new ExamineeServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        BeanUtils.copyProperties(examineePersonalInfoDto, examineePersonalInfoEntity);
        examineePersonalInfoRepository.save(examineePersonalInfoEntity);
    }

    @Override
    public void setEducationalInfo(String id,ExamineeEducationalInfoDto examineeEducationalInfoDto) {
        ExamineeEducationalInfoEntity examineeEducationalInfoEntity = new ExamineeEducationalInfoEntity();
        examineeEducationalInfoEntity.setCreated_at(new Date(System.currentTimeMillis()));
        examineeEducationalInfoEntity.setUserID(id);
        examineeEducationalInfoEntity.setHigh_school_name(examineeEducationalInfoDto.getHigh_school_name());
        examineeEducationalInfoEntity.setHigh_school_graduation_year((examineeEducationalInfoDto.getHigh_school_graduation_year()));
        examineeEducationalInfoEntity.setUniversity_name(examineeEducationalInfoDto.getUniversity_name());
        examineeEducationalInfoEntity.setUniversity_graduation_year(examineeEducationalInfoDto.getUniversity_graduation_year());
        examineeEducationalInfoEntity.setFaculty(examineeEducationalInfoDto.getFaculty());
        examineeEducationalInfoEntity.setMajor(examineeEducationalInfoDto.getMajor());
        examineeEducationalInfoEntity.setGrade(examineeEducationalInfoDto.getGrade());

        examineeEducationalInfoRepository.save(examineeEducationalInfoEntity);

        for(int i=0;i<examineeEducationalInfoDto.getAddMoreItems().size();i++){
            EducationalExtraInfoEntity educationalExtraInfoEntity = new EducationalExtraInfoEntity();
            educationalExtraInfoEntity.setCreated_at(new Date(System.currentTimeMillis()));
            educationalExtraInfoEntity.setUser_id(examineeEducationalInfoDto.getUserId());
            for(int j=0;j<examineeEducationalInfoDto.getAddMoreItems().get(i).size();j++){
                switch(j){
                    case 0:educationalExtraInfoEntity.setCertificate_degree(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j)); break;
                    case 1:educationalExtraInfoEntity.setProvider(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j));break;
                    case 2:educationalExtraInfoEntity.setYear(Integer.parseInt(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j)));break;
                    default:break;
                }
            }
            educationalExtraInfoRepository.save(educationalExtraInfoEntity);
        }

    }
}
