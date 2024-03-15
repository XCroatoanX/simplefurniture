package com.example.simplefurniture_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "Users")
public class CustomUser {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String role;

    public CustomUser() {
    }

    public CustomUser(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    
    
    //setters
    public void setEmail(String username) {
        this.email = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    //getters
    public String getEmail() {
    return email;
    }
    public String getPassword() {
        return password;
    }
    public Long getId() {
        return id;
    }
    public String getRole() {
        return role;
    }
}
