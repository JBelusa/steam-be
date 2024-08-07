package com.example.first_app.repository;

import com.example.first_app.model.Developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Developer entities.
 * Extends the JpaRepository interface to provide CRUD operations and query methods for the Developer entity.
 */
@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Long> {

}
