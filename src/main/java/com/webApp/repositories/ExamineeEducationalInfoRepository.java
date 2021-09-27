package com.webApp.repositories;

import com.webApp.entities.ExamineeEducationalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamineeEducationalInfoRepository extends CrudRepository<ExamineeEducationalInfoEntity,String>, JpaRepository<ExamineeEducationalInfoEntity,String>{
}
