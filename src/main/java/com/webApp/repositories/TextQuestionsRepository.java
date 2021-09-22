package com.webApp.repositories;

import com.webApp.entities.TextQuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextQuestionsRepository extends JpaRepository<TextQuestionsEntity,Long> {
}
