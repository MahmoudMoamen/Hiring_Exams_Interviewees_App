package com.webApp.serviceImplemetations;

import com.webApp.QuestionDto;
import com.webApp.entities.ParagraphsEntity;
import com.webApp.entities.QuestionHeadersEntity;

import com.webApp.entities.QuestionsDetailsEntity;
import com.webApp.repositories.ParagraphsRepository;
import com.webApp.repositories.QuestionDetailsRepository;
import com.webApp.repositories.QuestionHeadersRepository;
import com.webApp.responses.QuestionResponse;
import com.webApp.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class QuestionServiceImplementation implements QuestionService {
    @Autowired
    QuestionHeadersRepository questionHeadersRepository;

    @Autowired
    QuestionDetailsRepository questionDetailsRepository;

    @Autowired
    ParagraphsRepository paragraphsRepository;

    @Override
    public QuestionResponse setQuestion(QuestionDto questionDto) {
        ParagraphsEntity paragraphsEntity = new ParagraphsEntity();
        QuestionResponse returnValue = new QuestionResponse();
        if (questionDto.getTypeId() == 4) {
            for (int i = 0; i < questionDto.getParagraphQuestions().size(); i++) {
                QuestionHeadersEntity questionHeadersEntity = new QuestionHeadersEntity();
                BeanUtils.copyProperties(questionDto, questionHeadersEntity);
                questionHeadersEntity.setCreated_at(new Date(System.currentTimeMillis()));
                questionHeadersEntity.setType_id(questionDto.getTypeId());
                if (questionDto.getTopic().equalsIgnoreCase("English"))
                    questionHeadersEntity.setTopic_id(1);
                else if (questionDto.getTopic().equalsIgnoreCase("IQ"))
                    questionHeadersEntity.setTopic_id(2);
                else if (questionDto.getTopic().equalsIgnoreCase("Java / SQL"))
                    questionHeadersEntity.setTopic_id(3);
                else if (questionDto.getTopic().equalsIgnoreCase("Angular"))
                    questionHeadersEntity.setTopic_id(4);
                questionHeadersEntity.setHas_paragraph(true);
                questionHeadersEntity.setParagraph_id(questionDto.getParagraphId());
                questionHeadersEntity.setQuestion(questionDto.getParagraphQuestions().get(i));
                QuestionHeadersEntity storedParagraphQuestion = questionHeadersRepository.save(questionHeadersEntity);
                for (int q = 0; q < questionDto.getParagraphChoices().size(); q++) {
                    for (int j = 0; j < questionDto.getParagraphChoices().get(q).size(); j++) {
                        QuestionsDetailsEntity questionsDetailsEntity = new QuestionsDetailsEntity();
                        BeanUtils.copyProperties(questionDto, questionsDetailsEntity);
                        questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
                        questionsDetailsEntity.setQuestion_header_id(storedParagraphQuestion.getId());
                        questionsDetailsEntity.setValue(questionDto.getParagraphChoices().get(q).get(j));
                        if (questionDto.getParagraphChoices().get(q).get(j).equals(questionDto.getParagraphAnswers().get(q)))
                            questionsDetailsEntity.setResult(true);
                        else
                            questionsDetailsEntity.setResult(false);
                        questionDetailsRepository.save(questionsDetailsEntity);
                    }
                }
                returnValue.setParagraphAnswers(questionDto.getParagraphAnswers());
                returnValue.setId(storedParagraphQuestion.getId());
                returnValue.setParagraphQuestions(questionDto.getParagraphQuestions());
                returnValue.setTypeId(storedParagraphQuestion.getType_id());
                returnValue.setTopicId(questionHeadersEntity.getTopic_id());
                returnValue.setParagraphChoices(questionDto.getParagraphChoices());
                returnValue.setParagraphId(questionHeadersEntity.getParagraph_id());
                returnValue.setParagraphPrompt(questionDto.getParagraphPrompt());
            }
            paragraphsEntity.setCreated_at(new Date(System.currentTimeMillis()));
            paragraphsEntity.setParagragh(questionDto.getParagraphPrompt());
            paragraphsEntity.setParagraph_id(questionDto.getParagraphId());
            paragraphsRepository.save(paragraphsEntity);
        } else {
            QuestionHeadersEntity storedQuestionHeadersEntity = new QuestionHeadersEntity();
            if (questionDto.getTopic().equalsIgnoreCase("English"))
                storedQuestionHeadersEntity.setTopic_id(1);
            else if (questionDto.getTopic().equalsIgnoreCase("IQ"))
                storedQuestionHeadersEntity.setTopic_id(2);
            else if (questionDto.getTopic().equalsIgnoreCase("Java / SQL"))
                storedQuestionHeadersEntity.setTopic_id(3);
            else if (questionDto.getTopic().equalsIgnoreCase("Angular"))
                storedQuestionHeadersEntity.setTopic_id(4);

            storedQuestionHeadersEntity.setQuestion(questionDto.getQuestionHeader());
            storedQuestionHeadersEntity.setCreated_at(new Date(System.currentTimeMillis()));
            storedQuestionHeadersEntity.setType_id(questionDto.getTypeId());

            QuestionHeadersEntity storedQuestionHeader = questionHeadersRepository.save(storedQuestionHeadersEntity);

            for (int i = 0; i < questionDto.getChoices().size(); i++) {
                QuestionsDetailsEntity questionsDetailsEntity = new QuestionsDetailsEntity();
                BeanUtils.copyProperties(questionDto, questionsDetailsEntity);
                questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
                questionsDetailsEntity.setQuestion_header_id(storedQuestionHeader.getId());
                questionsDetailsEntity.setValue(questionDto.getChoices().get(i));
                if (questionDto.getChoices().get(i).equals(questionDto.getModelAnswer()))
                    questionsDetailsEntity.setResult(true);
                else
                    questionsDetailsEntity.setResult(false);
                questionDetailsRepository.save(questionsDetailsEntity);
            }
            returnValue.setId(storedQuestionHeader.getId());
            returnValue.setQuestionHeader(storedQuestionHeader.getQuestion());
            returnValue.setTypeId(storedQuestionHeader.getType_id());
            returnValue.setTopicId(storedQuestionHeadersEntity.getTopic_id());
            returnValue.setChoices(questionDto.getChoices());
            returnValue.setModelAnswer(questionDto.getModelAnswer());
        }
        return returnValue;
    }
}
