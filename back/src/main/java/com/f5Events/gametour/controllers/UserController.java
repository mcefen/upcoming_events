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

import com.f5Events.gametour.models.User;
import com.f5Events.gametour.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

     @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User serviceSaved = service.create(user);
        return ResponseEntity.status(HttpStatus.OK).body(serviceSaved);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findOne(@PathVariable("id") Long id){
        User findbyid = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(findbyid);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user1, @RequestBody User newuser){
        User serviceupdated = service.update(id, user1, newuser);
        return ResponseEntity.status(HttpStatus.OK).body(serviceupdated);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<User> delete(@PathVariable("id") Long id, @RequestBody User user1) {
       User serviceDeleted = service.delete(id, user1);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        List<User> serviceGetAll = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceGetAll);
    } 
}
