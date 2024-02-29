package com.example.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Plant;
import com.example.onetomany.repository.PlantRepo;

@Service
public class PlantService {
    @Autowired
    private final PlantRepo repo;
    // private final DescriptionRepo rep;

    public PlantService(PlantRepo repo) {
        this.repo = repo;
        // this.rep=rep;
    }

    public Plant addPlant(Plant p) {
        return repo.save(p);
    }

    public List<Plant> getPlant() {
        return repo.findAll();
    }

    public Plant getPlantbyId(int plantId) {
        return repo.findById(plantId).orElse(null);
    }

    // public Plant update(int plantId, Plant pro) {
    // Plant pros = repo.findById(plantId).orElse(null);
    // if (pros != null) {
    // pros.setPlantId(pro.getPlantId());
    // pros.setPlantName(pro.getPlantName());
    // pros.setPlantLight(pro.getPlantLight());
    // pros.setPlantSoil(pro.getPlantSoil());
    // pros.setPlantWater(pro.getPlantWater());
    // pros.setTempHumi(pro.getTempHumi());
    // return repo.save(pros);
    // }
    // return pro;
    // }

    // public boolean delete(int plantId) {
    // repo.deleteById(plantId);
    // // return true;
    // // }

    // public List<Description> sortTheRecords(String clientName)
    // {
    // return rep.findAll(Sort.by(Sort.Direction.DESC,clientName));
    // }

    // public List<Description> getPaginationSignin(int offset, int size) {
    // return repo.findAll(PageRequest.of(offset, size)).getContent();
    // }

    public List<Plant> getSortedPaginationSignin(int offset, int size, String field) {
        return repo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

    public List<Plant> getPaginationSignin(int offset, int size) {
        return repo.findAll(PageRequest.of(offset, size)).getContent();
    }
}