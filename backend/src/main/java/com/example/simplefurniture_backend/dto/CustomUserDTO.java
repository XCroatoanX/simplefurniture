package com.example.simplefurniture_backend.dto;

import com.example.simplefurniture_backend.models.Address;

public class CustomUserDTO {
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public Address address;
    public boolean isAdmin;

    public CustomUserDTO(String email, String password, boolean isAdmin, Address address, String firstName, String lastName) {
        this.address = address;
        this.isAdmin = isAdmin;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }
}
