package com.webApp.serviceImplemetations;

import com.webApp.entities.ParagraphsEntity;
import com.webApp.entities.QuestionHeadersEntity;
import com.webApp.entities.QuestionsDetailsEntity;
import com.webApp.entities.QuestionsTypeEntity;
import com.webApp.exceptions.QuestionServiceException;
import com.webApp.repositories.QuestionsTypesRepository;
import com.webApp.responses.ErrorMessages;
import com.webApp.shared.GetQuestionDto;
import com.webApp.shared.QuestionDto;

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
    QuestionsTypesRepository questionsTypesRepository;

    @Autowired
    ParagraphsRepository paragraphsRepository;

    @Override
    public void setQuestion(QuestionDto questionDto) {

        if (questionDto.getTypeId() == 4) {
            ParagraphsEntity paragraphsEntity = new ParagraphsEntity();
            paragraphsEntity.setCreated_at(new Date(System.currentTimeMillis()));
            paragraphsEntity.setParagraph(questionDto.getParagraphPrompt());
            paragraphsEntity.setId(questionDto.getParagraphId());
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
                questionHeadersEntity.setParagraph_id(paragraphsEntity.getId());
                questionHeadersEntity.setQuestion(questionDto.getParagraphQuestions().get(i));
                QuestionHeadersEntity storedParagraphQuestion = questionHeadersRepository.save(questionHeadersEntity);
                for (int j = 0; j < questionDto.getParagraphChoices().get(i).size(); j++) {
                    QuestionsDetailsEntity questionsDetailsEntity = new QuestionsDetailsEntity();
                    BeanUtils.copyProperties(questionDto, questionsDetailsEntity);
                    questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
                    questionsDetailsEntity.setQuestionHeaderId(storedParagraphQuestion.getId());
                    questionsDetailsEntity.setValue(questionDto.getParagraphChoices().get(i).get(j));
                    if (questionDto.getParagraphChoices().get(i).get(j).equals(questionDto.getParagraphAnswers().get(i)))
                        questionsDetailsEntity.setResult(true);
                    else
                        questionsDetailsEntity.setResult(false);
                    questionDetailsRepository.save(questionsDetailsEntity);
                }
            }
        } else {
            QuestionHeadersEntity storedQuestionHeadersEntity = new QuestionHeadersEntity();
            BeanUtils.copyProperties(questionDto,storedQuestionHeadersEntity);
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
            questionHeadersRepository.save(storedQuestionHeadersEntity);

            for (int i = 0; i < questionDto.getChoices().size(); i++) {
                QuestionsDetailsEntity questionsDetailsEntity = new QuestionsDetailsEntity();
                questionsDetailsEntity.setCreated_at(new Date(System.currentTimeMillis()));
                questionsDetailsEntity.setQuestionHeaderId(storedQuestionHeadersEntity.getId());
                questionsDetailsEntity.setValue(questionDto.getChoices().get(i));
                if (questionDto.getChoices().get(i).equals(questionDto.getModelAnswer()))
                    questionsDetailsEntity.setResult(true);
                else
                    questionsDetailsEntity.setResult(false);
                questionDetailsRepository.saveAndFlush(questionsDetailsEntity);
            }
        }
    }

    @Override
    public QuestionResponse getQuestions(GetQuestionDto getQuestionDto) {
        QuestionDto questionDto = new QuestionDto();
        QuestionResponse returnValue = new QuestionResponse();
        ArrayList<String> randomQuestions = new ArrayList<>();
        ArrayList<ArrayList<String>> choicesOfRandomQuestions = new ArrayList<>();
        ArrayList<Long> IDsOfRandomQuestions = new ArrayList<>();
        List<QuestionHeadersEntity> questionHeadersEntityList = questionHeadersRepository.findAll();
        List<QuestionsDetailsEntity> questionsDetailsEntityList = questionDetailsRepository.findAll();
        List<QuestionsTypeEntity> questionsTypeEntityList = questionsTypesRepository.findAll();
        ArrayList<ArrayList<String>> allChoices = new ArrayList<>();
        ArrayList<Long> RandomQuestionIdList = new ArrayList<>();
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
                        if (questionsDetailsEntityList.get(q).getQuestionHeaderId() == questionHeadersEntityList.get(x).getId()) {
                            allValuesOfQuestion.add(questionsDetailsEntityList.get(q).getValue());
                        }
                    }
                    allChoices.add(allValuesOfQuestion);
                    RandomQuestionIdList.add(questionHeadersEntityList.get(x).getId());
                } //else {
//                    questionDto.setParagraphPrompt(paragraphsEntityList.get(x).getParagraph());
//                    questionDto.setParagraphId(paragraphsEntityList.get(x).getParagraph_id());
//                    for (int h = 0; h < questionHeadersEntityList.size(); h++) {
//                        if (questionHeadersEntityList.get(h).getParagraph_id() == questionDto.getParagraphId() && questionsDetailsEntityList.get(h).getQuestion_header_id() == questionHeadersEntityList.get(x).getId()) {
//                            paragraphQuest.add(questionHeadersEntityList.get(h).getQuestion());
//                        }
//                        questionDto.setParagraphQuestions(paragraphQuest);
//                    }
//                    for (int l = 0; l < questionsDetailsEntityList.size(); l++) {
//                        if (questionsDetailsEntityList.get(l).getQuestion_header_id() == questionHeadersEntityList.get(x).getId()) {
//                            paragraphChoic.add(questionsDetailsEntityList.get(l).getValue());
//                        }
//                        allChoices.add(paragraphChoic);
//                        questionDto.setParagraphChoices(allChoices);
//                    }
//                }
            }

            ArrayList<String> questionsTemp = allQuestions;
            ArrayList<ArrayList<String>> choicesTemp = allChoices;
            ArrayList<Long> randomQuestionsIDsTemp = RandomQuestionIdList;
            int c=0;
            for (int j = 0; j < getQuestionDto.getNoOfQuestionsInTopic().get(i); j++) {
                long maxOfQuestions = questionsTemp.size();
                int randomIndex = (int) (Math.random() * maxOfQuestions);
                randomQuestions.add(allQuestions.get(randomIndex));
                c++;
                shufflingQuestions(getQuestionDto.getNoOfQuestionsInTopic().get(i), questionsTypeEntityList.size());
                choicesOfRandomQuestions.add(allChoices.get(randomIndex));
                IDsOfRandomQuestions.add(RandomQuestionIdList.get(randomIndex));
                questionsTemp.remove(randomIndex);
                choicesTemp.remove(randomIndex);
                randomQuestionsIDsTemp.remove(randomIndex);
            }

            if(randomQuestions.contains(questionDto.getQuestionHeader()) && c<(((getQuestionDto.getNoOfQuestionsInTopic().get(i))*3)/4)/3)
                randomQuestions.remove(questionDto.getQuestionHeader());
            returnValue.setRandomQuestionIDs(IDsOfRandomQuestions);
            returnValue.setRandomQuestionsChoices(choicesOfRandomQuestions);
            returnValue.setQuestionsReturnedRandomly(randomQuestions);
            returnValue.setNoOfQuestionsInTopic(getQuestionDto.getNoOfQuestionsInTopic());
            returnValue.setTopics(getQuestionDto.getTopics());
        }
        return returnValue;
    }

    @Override
    public void shufflingQuestions(long requestedNoOfQuestions, long noOfTypes) {
        long shufflingOperation = requestedNoOfQuestions / noOfTypes;
        long reminder = requestedNoOfQuestions % noOfTypes;
        ArrayList<QuestionHeadersEntity> ShuffledMCQ = new ArrayList<>();
        ArrayList<QuestionHeadersEntity> ShuffledTrueOrFalse = new ArrayList<>();
        ArrayList<QuestionHeadersEntity> ShuffledTexts = new ArrayList<>();
        ArrayList<QuestionHeadersEntity> ShuffledParagraphs = new ArrayList<>();
        ShuffledMCQ.addAll(questionHeadersRepository.findDistinctByType_id(1, shufflingOperation));
        ShuffledTrueOrFalse.addAll(questionHeadersRepository.findDistinctByType_id(2, shufflingOperation));
        ShuffledTexts.addAll(questionHeadersRepository.findDistinctByType_id(3, shufflingOperation));
        ShuffledParagraphs.addAll(questionHeadersRepository.findDistinctByType_id(4, shufflingOperation));
        if (reminder != 0) {
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 1:
                    ShuffledMCQ.addAll(questionHeadersRepository.findDistinctByType_id(1, reminder));
                    break;
                case 2:
                    ShuffledTrueOrFalse.addAll(questionHeadersRepository.findDistinctByType_id(2, reminder));
                    break;
                case 3:
                    ShuffledTexts.addAll(questionHeadersRepository.findDistinctByType_id(3, reminder));
                    break;
                case 4:
                    ShuffledParagraphs.addAll(questionHeadersRepository.findDistinctByType_id(4, reminder));
                default:
                    return;
            }
        }
    }

    @Override
    public void deleteQuestion(long id) {
        if (questionHeadersRepository.findById(id)==null) throw new QuestionServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        QuestionHeadersEntity questionHeadersEntity=questionHeadersRepository.findById(id);
        List<QuestionsDetailsEntity> questionsDetailsEntity=questionDetailsRepository.findAllByQuestionHeaderId(id);
        if (questionHeadersEntity.getType_id()==4) {
            QuestionDto questionDto= new QuestionDto();
            questionDto.setParagraphId(questionHeadersEntity.getParagraph_id());
            Optional<ParagraphsEntity> paragraphsEntity = paragraphsRepository.findById(questionDto.getParagraphId());
            paragraphsRepository.delete(paragraphsEntity.get());
        }
        questionDetailsRepository.deleteAll(questionsDetailsEntity);
        questionHeadersRepository.delete(questionHeadersEntity);
    }
}
