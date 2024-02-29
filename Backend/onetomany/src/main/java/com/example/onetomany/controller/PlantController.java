package com.example.onetomany.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Plant;
import com.example.onetomany.service.PlantService;

@RestController
@RequestMapping("/api")
public class PlantController {
    private final PlantService serv;

    public PlantController(PlantService serv) {
        this.serv = serv;
    }

    @PostMapping("/map")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant pro) {
        Plant addedPlant = serv.addPlant(pro);
        return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
    }

    @GetMapping("/map")
    public ResponseEntity<List<Plant>> getPlant() {
        List<Plant> plants = serv.getPlant();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("map/{plantId}")
    public ResponseEntity<Plant> getPlantbyId(@PathVariable int plantId) {
        Plant project = serv.getPlantbyId(plantId);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Plant>> getSortedPagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size, @PathVariable("field") String field) {
        List<Plant> list = serv.getSortedPaginationSignin(offset, size, field);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Plant>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size) {
        List<Plant> list = serv.getPaginationSignin(offset, size);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}