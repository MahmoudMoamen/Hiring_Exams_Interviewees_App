package com.webApp.repositories;

import com.webApp.entities.ExamineesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamineeRepository extends CrudRepository<ExamineesEntity,String>, JpaRepository<ExamineesEntity,String> {

}
