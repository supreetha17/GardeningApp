package com.example.gardening.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gardening.model.Project;
import com.example.gardening.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepo repo;

    public ProjectService(ProjectRepo repo) {
        this.repo = repo;
    }

    public Project addPlant(Project p) {
        return repo.save(p);
    }

    public List<Project> getPlant() {
        return repo.findAll();
    }

    public Project getPlantbyId(int plantId) {
        return repo.findById(plantId).orElse(null);
    }

    public Project update(int id, Project pro) {
        Project pros = repo.findById(id).orElse(null);
        if (pros != null) {
            pros.setPlantId(pro.getPlantId());
            pros.setPlantName(pro.getPlantName());
            pros.setPlantLight(pro.getPlantLight());
            pros.setPlantSoil(pro.getPlantSoil());
            pros.setPlantWater(pro.getPlantWater());
            pros.setTempHumi(pro.getTempHumi());
            return repo.save(pros);
        }
        return pro;
    }

    public boolean delete(int id) {
        repo.deleteById(id);
        return true;
    }
}