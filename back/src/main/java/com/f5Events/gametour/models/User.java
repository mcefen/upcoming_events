package com.f5Events.gametour.models;

import java.util.Set;
import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_user")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "password1")
 
    private String password1;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "iduser")
    Set<EventGames> eventgames;  
    
    
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

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
