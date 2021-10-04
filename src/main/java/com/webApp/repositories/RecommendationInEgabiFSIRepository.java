package com.webApp.repositories;

import com.webApp.entities.RecommendationInEgabifsiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationInEgabiFSIRepository extends CrudRepository<RecommendationInEgabifsiEntity,Long>, JpaRepository<RecommendationInEgabifsiEntity,Long> {
}
