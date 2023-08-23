package com.f5Events.gametour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f5Events.gametour.models.EventGames;
import com.f5Events.gametour.services.EventGamesService;


@RestController
@RequestMapping("/eventgames")
/* @CrossOrigin(origins = "http://localhost:63120") */
public class EventGamesController {
    private EventGamesService service;


    @Autowired
    public EventGamesController(EventGamesService service) {
        this.service = service;
    }

     @PostMapping
    public ResponseEntity<EventGames> create(@RequestBody EventGames eventgame){
        EventGames serviceSaved = service.create(eventgame);
        return ResponseEntity.status(HttpStatus.OK).body(serviceSaved);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<EventGames> findOne(@PathVariable("id") Long id){
        EventGames findbyid = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(findbyid);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EventGames> update(@PathVariable("id") Long id, @RequestBody EventGames eventGames1, @RequestBody EventGames neweventGames){
        EventGames serviceupdated = service.update(id, eventGames1, neweventGames);
        return ResponseEntity.status(HttpStatus.OK).body(serviceupdated);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<EventGames> delete(@PathVariable("id") Long id, @RequestBody EventGames eventGames1) {
        EventGames serviceDeleted = service.delete(id, eventGames1);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

    @GetMapping
    public ResponseEntity<List<EventGames>>  findAll(){
        List<EventGames> serviceGetAll = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceGetAll);
    }

}
