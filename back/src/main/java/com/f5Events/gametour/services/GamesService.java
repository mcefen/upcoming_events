package com.f5Events.gametour.services;

import com.f5Events.gametour.repositories.GamesRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f5Events.gametour.models.Games;


@Service
public class GamesService {

    GamesRepository repository;

    @Autowired
    public GamesService(GamesRepository repository) {
        this.repository = repository;
    }

       public Games create(Games game){
        Games gameSaved = repository.save(game);
        return gameSaved;
    }

    public Games findById(Long id) {
        Games game =  repository.findById(id).orElseThrow();
        return game;
    }

    public Games update(Long id, Games game1, Games newGame){
         game1 = repository.findById(id).orElseThrow();
        newGame.setName(game1.getName());
        newGame.setAbbreviation(game1.getAbbreviation());
        return repository.save(newGame);
    }
    
    public Games delete(Long id, Games game1){
        game1 = repository.findById(id).orElseThrow();
        repository.deleteById(game1.getId());
        return game1;
    }
    
    public List<Games> getAll() {
        List<Games> games = repository.findAll();
        return games;
    }







    
}
