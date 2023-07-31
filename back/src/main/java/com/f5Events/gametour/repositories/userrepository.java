package com.f5Events.gametour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f5Events.gametour.models.User;

@Repository
public interface userrepository extends JpaRepository<User,Long>{
    
}




