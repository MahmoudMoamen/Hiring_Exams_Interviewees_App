package com.webApp.repositories;


import com.webApp.entities.QuestionsDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDetailsRepository extends CrudRepository<QuestionsDetailsEntity,Long> , JpaRepository<QuestionsDetailsEntity,Long> {
    List<QuestionsDetailsEntity> findAllByQuestionHeaderId(long id);
}
