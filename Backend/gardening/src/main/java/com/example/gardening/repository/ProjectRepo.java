package com.example.gardening.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gardening.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}