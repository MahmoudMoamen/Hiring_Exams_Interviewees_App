package com.webApp.repositories;

import com.webApp.entities.ReferenceCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceCheckRepository extends CrudRepository<ReferenceCheckEntity,Long>, JpaRepository<ReferenceCheckEntity,Long> {
}
