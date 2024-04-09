package com.example.simplefurniture_backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String password;
    private boolean isAdmin;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Address address;

    public CustomUser() {
    }

    public CustomUser(String email, String password, boolean isAdmin, Address address, String firstName,
            String lastName) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setAdress(Address adress) {
        this.address = adress;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

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

    public boolean getAdmin() {
        return isAdmin;
    }

    public Address getAdress() {
        return address;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }
}
