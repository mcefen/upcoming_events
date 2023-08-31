package com.f5Events.gametour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f5Events.gametour.models.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games,Long> {
    
}
