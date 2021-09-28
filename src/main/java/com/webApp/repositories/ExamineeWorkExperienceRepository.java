package com.webApp.repositories;

import com.webApp.entities.ExamineeEducationalInfoEntity;
import com.webApp.entities.ExamineeWorkExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamineeWorkExperienceRepository extends CrudRepository<ExamineeWorkExperienceEntity,Long>, JpaRepository<ExamineeWorkExperienceEntity,Long> {
    ExamineeWorkExperienceEntity findByUserId(String id);
}
