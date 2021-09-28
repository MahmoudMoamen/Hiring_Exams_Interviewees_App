package com.webApp.service;

import com.webApp.shared.ExamineeEducationalInfoDto;
import com.webApp.shared.ExamineePersonalInfoDto;
import com.webApp.shared.ExamineeWorkExpDto;

public interface FormService {
    void insertUser(ExamineePersonalInfoDto examineePersonalInfoDto);
    void updateUser(String id,ExamineePersonalInfoDto examineePersonalInfoDto);
    void setEducationalInfo(String id,ExamineeEducationalInfoDto examineeEducationalInfoDto);
    void updateEducationalInfo(String id,ExamineeEducationalInfoDto examineeEducationalInfoDto);
    void setWorkExperienceInfo(String id, ExamineeWorkExpDto examineeWorkExpDto);
}
