package com.example.simplefurniture_backend.dto;

public class AuthenticationDTO {
    public String email;
    public String password;
    public boolean isAdmin;
    public String address;
    public String FirstName;
    public String LastName;

    public AuthenticationDTO(String email, String password, boolean isAdmin, String address, String FirstName, String LastName) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
}
