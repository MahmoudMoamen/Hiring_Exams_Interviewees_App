package com.webApp.repositories;

import com.webApp.entities.QuestionHeadersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionHeadersRepository extends JpaRepository<QuestionHeadersEntity, Long> {
    QuestionHeadersEntity findById(long id);

    @Query(nativeQuery = true, value = "select * from hr_app.questions_headers where type_id = ?1 ORDER BY RAND() LIMIT ?2")
    List<QuestionHeadersEntity> findDistinctByType_id(int typeId, long shufflingOperation);

}
