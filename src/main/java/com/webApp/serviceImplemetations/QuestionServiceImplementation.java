package com.webApp.serviceImplemetations;

import com.webApp.shared.GetQuestionDto;
import com.webApp.shared.QuestionDto;
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

import java.util.*;

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

        QuestionResponse returnValue = new QuestionResponse();
        if (questionDto.getTypeId() == 4) {
            ParagraphsEntity paragraphsEntity = new ParagraphsEntity();
            paragraphsEntity.setCreated_at(new Date(System.currentTimeMillis()));
            paragraphsEntity.setParagraph(questionDto.getParagraphPrompt());
            paragraphsEntity.setParagraph_id(questionDto.getParagraphId());
            paragraphsEntity = paragraphsRepository.save(paragraphsEntity);
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
                questionHeadersEntity.setParagraph_id(paragraphsEntity.getParagraph_id());
                questionHeadersEntity.setQuestion(questionDto.getParagraphQuestions().get(i));
                QuestionHeadersEntity storedParagraphQuestion = questionHeadersRepository.save(questionHeadersEntity);
                for (int j = 0; j < questionDto.getParagraphChoices().get(i).size(); j++) {
                    QuestionsDetailsEntity questionsDetailsEntity = new QuestionsDetailsEntity();
                    BeanUtils.copyProperties(questionDto, questionsDetailsEntity);
                    questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
                    questionsDetailsEntity.setQuestion_header_id(storedParagraphQuestion.getId());
                    questionsDetailsEntity.setValue(questionDto.getParagraphChoices().get(i).get(j));
                    if (questionDto.getParagraphChoices().get(i).get(j).equals(questionDto.getParagraphAnswers().get(i)))
                        questionsDetailsEntity.setResult(true);
                    else
                        questionsDetailsEntity.setResult(false);
                    questionDetailsRepository.save(questionsDetailsEntity);
                }
                returnValue.setParagraphAnswers(questionDto.getParagraphAnswers());
                returnValue.setId(storedParagraphQuestion.getId());
                returnValue.setParagraphQuestions(questionDto.getParagraphQuestions());
                returnValue.setTypeId(storedParagraphQuestion.getType_id());
                returnValue.setTopicId(questionHeadersEntity.getTopic_id());
                returnValue.setParagraphChoices(questionDto.getParagraphChoices());
                returnValue.setParagraphPrompt(questionDto.getParagraphPrompt());
                returnValue.setHasParagraph(questionHeadersEntity.getHas_paragraph());
                returnValue.setParagraphId(paragraphsEntity.getParagraph_id());
            }
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
            storedQuestionHeadersEntity.setParagraph_id(questionDto.getParagraphId());

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

    @Override
    public QuestionResponse getQuestions(GetQuestionDto getQuestionDto) {
        QuestionDto questionDto = new QuestionDto();
        QuestionResponse returnValue = new QuestionResponse();
        ArrayList<String> randomElements = new ArrayList<>();
        List<QuestionHeadersEntity> questionHeadersEntityList = questionHeadersRepository.findAll();
        List<QuestionsDetailsEntity> questionsDetailsEntityList = questionDetailsRepository.findAll();
        ArrayList<ArrayList<String>> allChoices = new ArrayList<>();
        ArrayList<Long> RandomQuestionIdList= new ArrayList<>();
        for (int i = 0; i < getQuestionDto.getTopics().size(); i++) {
            if (getQuestionDto.getTopics().get(i).equalsIgnoreCase("English"))
                questionDto.setTopicId(1);
            else if (getQuestionDto.getTopics().get(i).equalsIgnoreCase("IQ"))
                questionDto.setTopicId(2);
            else if (getQuestionDto.getTopics().get(i).equalsIgnoreCase("Java / SQL"))
                questionDto.setTopicId(3);
            else if (getQuestionDto.getTopics().get(i).equalsIgnoreCase("Angular"))
                questionDto.setTopicId(4);


            ArrayList<String> allQuestions = new ArrayList<>();
            for (int x = 0; x < questionHeadersEntityList.size(); x++) {
                if (questionHeadersEntityList.get(x).getTopic_id() == questionDto.getTopicId() && questionHeadersEntityList.get(x).getType_id() != 4) {
                    questionDto.setQuestionHeader(questionHeadersEntityList.get(x).getQuestion());
                    allQuestions.add(questionDto.getQuestionHeader());
                    ArrayList<String> allValuesOfQuestion = new ArrayList<>();
                    for (int q = 0; q < questionsDetailsEntityList.size(); q++) {
                        if (questionsDetailsEntityList.get(q).getQuestion_header_id() == questionHeadersEntityList.get(x).getId()) {
                            allValuesOfQuestion.add(questionsDetailsEntityList.get(q).getValue());
                        }
                    }
                    allChoices.add(allValuesOfQuestion);
                    RandomQuestionIdList.add(questionsDetailsEntityList.get(x).getId());
                }
            }

            long max = allQuestions.size();
            for (int j = 0; j < getQuestionDto.getNoOfQuestionsInTopic().get(i); j++) {
                int randomIndex = (int) (Math.random() * max);
                randomElements.add(allQuestions.get(randomIndex));
            }
            returnValue.setRandomQuestionIDs(RandomQuestionIdList);
            returnValue.setRandomQuestionsChoices(allChoices);
            returnValue.setQuestionsReturnedRandomly(randomElements);
            returnValue.setNoOfQuestionsInTopic(getQuestionDto.getNoOfQuestionsInTopic());
            returnValue.setTopics(getQuestionDto.getTopics());
        }
        return returnValue;
    }
}
