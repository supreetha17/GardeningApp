package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Plant;

@Repository
public interface PlantRepo extends JpaRepository<Plant, Integer> {

}