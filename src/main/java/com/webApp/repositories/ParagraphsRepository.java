package com.webApp.repositories;

import com.webApp.entities.ParagraphsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphsRepository extends CrudRepository<ParagraphsEntity,Long> {

}
