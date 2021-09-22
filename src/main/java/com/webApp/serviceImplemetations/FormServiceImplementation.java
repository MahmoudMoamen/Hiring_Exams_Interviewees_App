package com.webApp.serviceImplemetations;

import com.webApp.entities.ExamineePersonalInfoEntity;
import com.webApp.entities.ExamineesEntity;
import com.webApp.repositories.ExamineePersonalInfoRepository;
import com.webApp.repositories.ExamineeRepository;
import com.webApp.service.FormService;
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
    @Override
    public void insertUser(ExamineePersonalInfoDto examineePersonalInfoDto) {
        ExamineePersonalInfoEntity examineePersonalInfoEntity= new ExamineePersonalInfoEntity();
        ExamineesEntity examineesEntity= new ExamineesEntity();
        examineePersonalInfoDto.setCreated_at(new Date(System.currentTimeMillis()));
        examineePersonalInfoDto.setUser_id(Utils.generateUserID());
        examineesEntity.setUser_id(examineePersonalInfoDto.getUser_id());
        examineesEntity.setUsername(examineePersonalInfoDto.getApplicant_name());
        examineesEntity.setEmail(examineePersonalInfoDto.getEmail());
        BeanUtils.copyProperties(examineePersonalInfoDto,examineePersonalInfoEntity);
        examineePersonalInfoRepository.save(examineePersonalInfoEntity);
    }
}
