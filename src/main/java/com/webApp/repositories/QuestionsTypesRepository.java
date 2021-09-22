package com.webApp.repositories;

import com.webApp.entities.QuestionsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsTypesRepository extends JpaRepository<QuestionsTypeEntity, Long> {
}
