package com.webApp.repositories;

import com.webApp.entities.EducationalExtraInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EducationalExtraInfoRepository extends CrudRepository<EducationalExtraInfoEntity,Integer>, JpaRepository<EducationalExtraInfoEntity,Integer> {
}
