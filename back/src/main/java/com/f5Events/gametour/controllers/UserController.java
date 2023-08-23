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

import com.f5Events.gametour.models.User1;
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
    public ResponseEntity<User1> create(@RequestBody User1 user){
        User1 serviceSaved = service.create(user);
        return ResponseEntity.status(HttpStatus.OK).body(serviceSaved);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User1> findOne(@PathVariable("id") Long id){
        User1 findbyid = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(findbyid);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User1> update(@PathVariable("id") Long id, @RequestBody User1 user1, @RequestBody User1 newuser){
        User1 serviceupdated = service.update(id, user1, newuser);
        return ResponseEntity.status(HttpStatus.OK).body(serviceupdated);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<User1> delete(@PathVariable("id") Long id, @RequestBody User1 user1) {
       User1 serviceDeleted = service.delete(id, user1);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

    @GetMapping
    public ResponseEntity<List<User1>>  findAll(){
        List<User1> serviceGetAll = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceGetAll);
    } 
}
