package com.example.simplefurniture_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "Users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String password;
    private boolean isAdmin;
    private String address;
    private String FirstName;
    private String LastName;


    public CustomUser() {
    }

    public CustomUser(String email, String password, boolean isAdmin, String address, String FirstName, String LastName) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    // setters
    public void setEmail(String username) {
        this.email = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setAdress(String adress) { this.address = adress; }

    public void setFirstName(String firstName) { FirstName = firstName; }

    public void setLastName(String lastName) { LastName = lastName; }

    // getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public boolean getAdmin() { return isAdmin; }

    public String getAdress() { return address; }

    public String getFirstName() { return FirstName; }

    public String getLastName() { return LastName; }
}
