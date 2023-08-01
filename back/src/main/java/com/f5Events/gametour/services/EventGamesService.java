package com.f5Events.gametour.services;

import com.f5Events.gametour.repositories.EventGamesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f5Events.gametour.models.EventGames;

@Service
public class EventGamesService {
    
   EventGamesRepository  repository;

   @Autowired
   public EventGamesService(EventGamesRepository repository) {
       this.repository = repository;
   }

      public EventGames create(EventGames eventgames){
        EventGames eventgamesSaved = repository.save(eventgames);
       return eventgamesSaved;
   }

   public EventGames findById(Long id) {
    EventGames  eventGames =  repository.findById(id).orElseThrow();
       return eventGames;
   }

   public EventGames update(Long id, EventGames eventgames1, EventGames neweventgames){
       eventgames1 = repository.findById(id).orElseThrow();
       neweventgames.setTitle(eventgames1.getTitle());
       neweventgames.setPublicationevent(eventgames1.getPublicationevent());
       neweventgames.setParticipants(eventgames1.getParticipants());
       neweventgames.setDescription(eventgames1.getDescription());
       neweventgames.setImage(eventgames1.getImage());
       return repository.save(neweventgames);
   }
   
   public EventGames delete(Long id, EventGames eventgames1){
       eventgames1 = repository.findById(id).orElseThrow();
       repository.deleteById(eventgames1.getId());
       return eventgames1;
   }
   
   public List<EventGames> getAll() {
       List<EventGames> eventgames = repository.findAll();
       return eventgames;
   }




}
