package com.example.gardening.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.gardening.model.Project;
import com.example.gardening.service.ProjectService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService serv;

    public ProjectController(ProjectService serv) {
        this.serv = serv;
    }

    @PostMapping("/garden")
    public ResponseEntity<Project> addPlant(@RequestBody Project pro) {
        Project addedPlant = serv.addPlant(pro);
        return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
    }

    @GetMapping("/gardening")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> plants = serv.getPlant();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("gardening/{plantId}")
    public ResponseEntity<Project> getPlantbyId(@PathVariable int plantId) {
        Project project = serv.getPlantbyId(plantId);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/gardening/{plantId}")
    public ResponseEntity<Project> update(@PathVariable int id, @RequestBody Project pro) {
        return new ResponseEntity<>(serv.update(id, pro), HttpStatus.OK);
    }

    @DeleteMapping("/gardening/{plantId}")
    public ResponseEntity<Boolean> delete(@PathVariable int plantId) {
        return new ResponseEntity<>(serv.delete(plantId), HttpStatus.OK);
    }
}