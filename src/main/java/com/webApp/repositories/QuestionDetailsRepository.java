package com.webApp.repositories;

import com.webApp.entities.QuestionsDetailsEntity;
import com.webApp.responses.QuestionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface QuestionDetailsRepository extends CrudRepository<QuestionsDetailsEntity,Long> , JpaRepository<QuestionsDetailsEntity,Long> {

}
