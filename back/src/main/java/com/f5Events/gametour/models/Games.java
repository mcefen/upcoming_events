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

    @Column(name = "publicationdate")
   
    private Date publicationdate;

    @Column(name = "genre")
    private String genre;
 
    @Column(name = "description")
    private String description;

    @Column(name = "outstanding")
    private String outstanding;

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

    public Date getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

       public String getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }
    
       public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }




}
