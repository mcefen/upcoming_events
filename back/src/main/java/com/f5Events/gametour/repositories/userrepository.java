package com.f5Events.gametour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f5Events.gametour.models.User1;

@Repository
public interface userrepository extends JpaRepository<User1,Long>{
    
}




