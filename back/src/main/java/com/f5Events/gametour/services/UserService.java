package com.f5Events.gametour.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f5Events.gametour.models.User1;
import com.f5Events.gametour.repositories.userrepository;

@Service
public class UserService {

    userrepository repository;


    @Autowired
    public UserService(userrepository repository) {
        this.repository = repository;
    }

       public User1 create(User1 user){
        User1 userSaved = repository.save(user);
        return userSaved;
    }

    public User1 findById(Long id) {
        User1 users =  repository.findById(id).orElseThrow();
        return users;
    }

    public User1 update(Long id, User1 user1, User1 newUser){
        user1 = repository.findById(id).orElseThrow();
        newUser.setName(user1.getName());
        newUser.setPassword(user1.getPassword());
        newUser.setRole(user1.getRole());
        return repository.save(newUser);
    }
    
    public User1 delete(Long id, User1 user){
        user = repository.findById(id).orElseThrow();
        repository.deleteById(user.getId());
        return user;
    }
    
    public List<User1> getAll() {
        List<User1> users = repository.findAll();
        return users;
    }
}
