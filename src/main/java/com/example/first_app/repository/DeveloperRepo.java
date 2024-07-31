package com.example.first_app.repository;

import com.example.first_app.model.Developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Long> {

}
