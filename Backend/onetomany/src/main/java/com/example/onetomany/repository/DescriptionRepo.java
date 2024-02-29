package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Description;

@Repository
public interface DescriptionRepo extends JpaRepository<Description, Integer> {

}