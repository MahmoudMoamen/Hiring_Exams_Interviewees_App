package com.webApp.repositories;

import com.webApp.QuestionDto;
import com.webApp.entities.QuestionHeadersEntity;
import com.webApp.entities.QuestionsDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionHeadersRepository extends CrudRepository<QuestionHeadersEntity,Long>,
        JpaRepository<QuestionHeadersEntity,Long> {

}
