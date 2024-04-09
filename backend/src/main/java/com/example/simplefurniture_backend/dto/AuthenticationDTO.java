package com.example.simplefurniture_backend.dto;

import com.example.simplefurniture_backend.models.Address;

public class AuthenticationDTO {
    public String email;
    public String password;
    public boolean isAdmin;
    public Address address;
    public String firstName;
    public String lastName;

    public AuthenticationDTO(String email, String password, boolean isAdmin, Address address, String firstName,
            String lastName) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
