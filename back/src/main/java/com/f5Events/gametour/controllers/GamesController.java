package com.f5Events.gametour.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f5Events.gametour.services.GamesService;
import com.f5Events.gametour.models.Games;

@RestController
@RequestMapping("/games")
public class GamesController {
    private GamesService service;

    @Autowired
    public GamesController(GamesService service) {
        this.service = service;
    }

     @PostMapping
    public ResponseEntity<Games> create(@RequestBody Games game){
        Games serviceSaved = service.create(game);
        return ResponseEntity.status(HttpStatus.OK).body(serviceSaved);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Games> findOne(@PathVariable("id") Long id){
        Games findbyid = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(findbyid);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Games> update(@PathVariable("id") Long id, @RequestBody Games game1, @RequestBody Games newGame){
        Games serviceupdated = service.update(id, game1, newGame);
        return ResponseEntity.status(HttpStatus.OK).body(serviceupdated);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<Games> delete(@PathVariable("id") Long id, @RequestBody Games game1) {
        Games serviceDeleted = service.delete(id, game1);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

    @GetMapping
    public ResponseEntity<List<Games>>  findAll(){
        List<Games> serviceGetAll = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceGetAll);
    }
}
