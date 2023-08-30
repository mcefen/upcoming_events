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

   public EventGames update(Long id, EventGames neweventgames){
       EventGames currentEventGame = repository.findById(id).orElseThrow();
       currentEventGame.setTitle(neweventgames.getTitle());
       currentEventGame.setPublicationevent(neweventgames.getPublicationevent());
       currentEventGame.setParticipants(neweventgames.getParticipants());
       currentEventGame.setLimitparticipants(neweventgames.getLimitparticipants());
       currentEventGame.setDescription(neweventgames.getDescription());
       currentEventGame.setImage(neweventgames.getImage());
       return repository.save(currentEventGame);
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
