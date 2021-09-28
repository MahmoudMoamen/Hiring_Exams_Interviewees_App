package com.webApp.repositories;

import com.webApp.entities.CompanyJobQuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJobQuestionsRepository extends CrudRepository<CompanyJobQuestionsEntity,String>, JpaRepository<CompanyJobQuestionsEntity,String> {

}
