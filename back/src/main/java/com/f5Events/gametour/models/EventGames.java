package com.f5Events.gametour.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table(name = "eventgames")
public class EventGames {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_eventgame")
    private Long id;
    
    @Column(name = "title")
    private String title;

    @Column(name = "publicationevent")


    private Date publicationevent;

    @Column(name = "participants")
    private Integer participants;

    @Column(name = "limitparticipants")
    private Integer limitparticipants;
 
    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_game", unique=false, nullable=true, insertable=true, updatable=true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

     private Games idgame; 

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_user", unique=false, nullable=true, insertable=true, updatable=true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    private User1 iduser;  
    
    
    
    
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

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
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

      public Integer getLimitparticipants() {
        return limitparticipants;
    }

    public void setLimitparticipants(Integer limitparticipants) {
        this.limitparticipants = limitparticipants;
    }
 
     public Games getIdgame() {
        return idgame;
    } 

    public void setIdgame(Games idgame) {
        this.idgame = idgame;
    }

      public User1 getIduser() {
        return iduser;
    }

    public void setIduser(User1 iduser) {
        this.iduser = iduser;
    } 
 
    
}
