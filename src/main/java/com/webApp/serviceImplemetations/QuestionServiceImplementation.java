package com.webApp.serviceImplemetations;

import com.webApp.QuestionDto;
import com.webApp.entities.QuestionHeadersEntity;

import com.webApp.entities.QuestionsDetailsEntity;
import com.webApp.repositories.QuestionDetailsRepository;
import com.webApp.repositories.QuestionHeadersRepository;
import com.webApp.responses.QuestionResponse;
import com.webApp.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QuestionServiceImplementation implements QuestionService {
    @Autowired
    QuestionHeadersRepository questionHeadersRepository;

    @Autowired
    QuestionDetailsRepository questionDetailsRepository;

    @Override
    public QuestionResponse setQuestion(QuestionDto questionDto) {
        QuestionHeadersEntity questionHeadersEntity= new QuestionHeadersEntity();
        QuestionsDetailsEntity questionsDetailsEntity=new QuestionsDetailsEntity();
        BeanUtils.copyProperties(questionDto,questionHeadersEntity);
        BeanUtils.copyProperties(questionDto,questionsDetailsEntity);
        questionHeadersEntity.setCreated_at(new Date(System.currentTimeMillis()));
        questionHeadersEntity.setType_id(questionDto.getTypeId());
        if(questionDto.getTopic().equals("English"))
            questionHeadersEntity.setTopic_id(1);
        else if(questionDto.getTopic().equals("IQ"))
            questionHeadersEntity.setTopic_id(2);
        else if(questionDto.getTopic().equals("Java / SQL"))
            questionHeadersEntity.setTopic_id(3);
        else if(questionDto.getTopic().equals("Angular"))
            questionHeadersEntity.setTopic_id(4);
        questionHeadersEntity.setQuestion(questionDto.getQuestionHeader());
        questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
        questionsDetailsEntity.setQuestion_header_id(questionHeadersEntity.getId());


        for(int i =0;i<questionDto.getChoices().size();i++){
            questionsDetailsEntity.setValue(questionDto.getChoices().get(i));
            if(questionDto.getChoices().get(i).equals(questionDto.getModelAnswer()))
                questionsDetailsEntity.setResult(true);
        }

        QuestionHeadersEntity storedQuestionHeader= questionHeadersRepository.save(questionHeadersEntity);
        //QuestionsDetailsEntity storedQuestionDetails= questionDetailsRepository.save(questionsDetailsEntity);
        QuestionResponse returnValue = new QuestionResponse();
        returnValue.setId(storedQuestionHeader.getId());
        returnValue.setQuestionHeader(storedQuestionHeader.getQuestion());
        returnValue.setTypeId(storedQuestionHeader.getType_id());
        returnValue.setTopicId(questionHeadersEntity.getTopic_id());
        returnValue.setChoices(questionDto.getChoices());
        returnValue.setModelAnswer(questionDto.getModelAnswer());
        return returnValue;
    }
}
