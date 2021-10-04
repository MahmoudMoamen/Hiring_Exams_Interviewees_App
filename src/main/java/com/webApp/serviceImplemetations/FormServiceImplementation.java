package com.webApp.serviceImplemetations;

import com.webApp.entities.*;
import com.webApp.exceptions.ExamineeServiceException;
import com.webApp.repositories.*;
import com.webApp.responses.ErrorMessages;
import com.webApp.service.FormService;
import com.webApp.shared.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    @Autowired
    ExamineeWorkExperienceRepository examineeWorkExperienceRepository;

    @Autowired
    CompanyJobQuestionsRepository companyJobQuestionsRepository;

    @Autowired
    RecommendationInEgabiFSIRepository recommendationInEgabiFSIRepository;

    @Autowired
    ReferenceCheckRepository referenceCheckRepository;


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
            educationalExtraInfoEntity.setUserId(examineeEducationalInfoDto.getUserId());
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
    @Override
    public void updateEducationalInfo(String id, ExamineeEducationalInfoDto examineeEducationalInfoDto) {
        ExamineeEducationalInfoEntity examineeEducationalInfoEntity=examineeEducationalInfoRepository.getOne(id);
        List<EducationalExtraInfoEntity> storedEducationalExtraInfoEntity=educationalExtraInfoRepository.findAllByUserId(id);
        educationalExtraInfoRepository.deleteAll(storedEducationalExtraInfoEntity);
        if (examineeEducationalInfoEntity==null) throw new ExamineeServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        BeanUtils.copyProperties(examineeEducationalInfoDto,examineeEducationalInfoEntity);
        for(int i=0;i<examineeEducationalInfoDto.getAddMoreItems().size();i++) {
            EducationalExtraInfoEntity educationalExtraInfoEntity = new EducationalExtraInfoEntity();
            educationalExtraInfoEntity.setCreated_at(new Date(System.currentTimeMillis()));
            educationalExtraInfoEntity.setUserId(examineeEducationalInfoDto.getUserId());
            for (int j = 0; j < examineeEducationalInfoDto.getAddMoreItems().get(i).size(); j++) {
                switch (j) {
                    case 0:
                        educationalExtraInfoEntity.setCertificate_degree(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j));
                        break;
                    case 1:
                        educationalExtraInfoEntity.setProvider(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j));
                        break;
                    case 2:
                        educationalExtraInfoEntity.setYear(Integer.parseInt(examineeEducationalInfoDto.getAddMoreItems().get(i).get(j)));
                        break;
                    default:
                        break;
                }
            }
            educationalExtraInfoRepository.save(educationalExtraInfoEntity);
        }
        examineeEducationalInfoRepository.save(examineeEducationalInfoEntity);
    }


    @Override
    public void setWorkExperienceInfo(String id, ExamineeWorkExpDto examineeWorkExpDto) {
        ExamineeWorkExperienceEntity examineeWorkExperienceEntity=new ExamineeWorkExperienceEntity();
        examineeWorkExperienceEntity.setCreatedAt(new Date(System.currentTimeMillis()));
        BeanUtils.copyProperties(examineeWorkExpDto,examineeWorkExperienceEntity);
        examineeWorkExperienceRepository.save(examineeWorkExperienceEntity);
    }
    @Override
    public void updateWorkExperienceInfo(String id, ExamineeWorkExpDto examineeWorkExpDto) {
        ExamineeWorkExperienceEntity examineeWorkExperienceEntity=examineeWorkExperienceRepository.findByUserId(id);
        BeanUtils.copyProperties(examineeWorkExpDto,examineeWorkExperienceEntity);
        examineeWorkExperienceRepository.save(examineeWorkExperienceEntity);
    }


    @Override
    public void setJobQuestionAns(String id, CompanyJobQuestionsDto companyJobQuestionsDto) {
        CompanyJobQuestionsEntity companyJobQuestionsEntity=new CompanyJobQuestionsEntity();
        companyJobQuestionsEntity.setCreated_at(new Date(System.currentTimeMillis()));
        BeanUtils.copyProperties(companyJobQuestionsDto,companyJobQuestionsEntity);
        companyJobQuestionsRepository.save(companyJobQuestionsEntity);
    }

    @Override
    public void updateJobAnswersInfo(String id, CompanyJobQuestionsDto companyJobQuestionsDto) {
        CompanyJobQuestionsEntity companyJobQuestionsEntity=companyJobQuestionsRepository.findByUserId(id);
        BeanUtils.copyProperties(companyJobQuestionsDto,companyJobQuestionsEntity);
        companyJobQuestionsRepository.save(companyJobQuestionsEntity);
    }

    @Override
    public void setFormExtraInfo(String id, FormExtraQuestionsDto formExtraQuestionsDto) {
        FormExtraQuestionsEntity formExtraQuestionsEntity=new FormExtraQuestionsEntity();
        formExtraQuestionsEntity.setCreated_at(new Date(System.currentTimeMillis()));
        formExtraQuestionsEntity.setUser_id(formExtraQuestionsDto.getUserId());
        formExtraQuestionsEntity.setHas_relatives(formExtraQuestionsDto.getHasRelatives());

        for (int i=0;i<formExtraQuestionsDto.getRecommendation().size();i++){
            RecommendationInEgabifsiEntity recommendationInEgabifsiEntity=new RecommendationInEgabifsiEntity();
            recommendationInEgabifsiEntity.setUser___id(formExtraQuestionsDto.getUserId());
            for (int j=0;j<formExtraQuestionsDto.getRecommendation().get(i).size();j++){
                switch (j){
                    case 0: recommendationInEgabifsiEntity.setName(formExtraQuestionsDto.getRecommendation().get(i).get(j));break;
                    case 1: recommendationInEgabifsiEntity.setTitle(formExtraQuestionsDto.getRecommendation().get(i).get(j));break;
                    case 2: recommendationInEgabifsiEntity.setMobile_no(formExtraQuestionsDto.getRecommendation().get(i).get(j));break;
                    default:break;
                }
            }
            recommendationInEgabifsiEntity.setCreated_at(new Date(System.currentTimeMillis()));
            recommendationInEgabiFSIRepository.save(recommendationInEgabifsiEntity);
        }

        for (int i=0;i<formExtraQuestionsDto.getReferenceCheck().size();i++){
            ReferenceCheckEntity referenceCheckEntity=new ReferenceCheckEntity();
            referenceCheckEntity.setUser_id(formExtraQuestionsDto.getUserId());
            for (int j=0;j<formExtraQuestionsDto.getReferenceCheck().get(i).size();j++){
                switch (j){
                    case 0:referenceCheckEntity.setName(formExtraQuestionsDto.getReferenceCheck().get(i).get(j));break;
                    case 1:referenceCheckEntity.setTitle(formExtraQuestionsDto.getReferenceCheck().get(i).get(j));break;
                    case 2:referenceCheckEntity.setEmployer(formExtraQuestionsDto.getReferenceCheck().get(i).get(j));break;
                    case 3:referenceCheckEntity.setMobile_no(formExtraQuestionsDto.getReferenceCheck().get(i).get(j));break;
                    default:break;
                }
            }
            referenceCheckEntity.setCreated_at(new Date(System.currentTimeMillis()));
            referenceCheckRepository.save(referenceCheckEntity);
        }
    }
}
