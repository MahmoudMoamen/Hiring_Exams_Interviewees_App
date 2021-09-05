package com.webApp.repositories;

import com.webApp.entities.AdminsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsRepository extends CrudRepository<AdminsEntity,Long> {
    AdminsEntity findByEmail(String email);
}
