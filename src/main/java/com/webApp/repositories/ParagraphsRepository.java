package com.webApp.repositories;

import com.webApp.entities.ParagraphsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParagraphsRepository extends JpaRepository<ParagraphsEntity,Long> {

    Optional<ParagraphsEntity> findById(Long id);
}
