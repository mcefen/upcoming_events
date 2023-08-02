package com.f5Events.gametour.models;

import java.sql.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Games {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_game")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;
    
    @OneToMany(mappedBy = "idgame")
    Set <EventGames> eventgames;
    
 

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }




}
