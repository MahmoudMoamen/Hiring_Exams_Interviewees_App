package com.webApp.repositories;

import com.webApp.entities.QuestionHeadersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface QuestionHeadersRepository extends JpaRepository<QuestionHeadersEntity,Long> {
}
