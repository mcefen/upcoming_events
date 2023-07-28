package com.f5Events.gametour.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "eventgames")
public class EventGames {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_eventgame")
    private Long id;
    
    @Column(name = "title")
    private String title;

    @Column(name = "publicationevent")
   /*  @DateTimeFormat(pattern = "dd/MM/yyyy")  */
    private Date publicationevent;

    @Column(name = "participants")
    private Number participants;

    @Column(name = "limitparticipants")
    private Number limitparticipants;
 
    @Column(name = "description")
    private String description;

     @Column(name = "image")
    private String image;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationevent() {
        return publicationevent;
    }

    public void setPublicationevent(Date publicationevent) {
        this.publicationevent = publicationevent;
    }

    public Number getParticipants() {
        return participants;
    }

    public void setParticipants(Number participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

      public Number getLimitparticipants() {
        return limitparticipants;
    }

    public void setLimitparticipants(Number limitparticipants) {
        this.limitparticipants = limitparticipants;
    }
}
