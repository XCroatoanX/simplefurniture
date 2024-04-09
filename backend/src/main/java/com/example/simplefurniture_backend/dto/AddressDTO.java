package com.example.simplefurniture_backend.dto;

public class AddressDTO {
    public String country;
    public String city;
    public String zipCode;
    public String street;

    public AddressDTO(String country, String street, String zipCode, String city) {
        this.country = country;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
}
