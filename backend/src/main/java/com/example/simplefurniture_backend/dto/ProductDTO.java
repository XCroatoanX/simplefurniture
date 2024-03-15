package com.example.simplefurniture_backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ProductDTO {
    public String name;
    public String description;
    public double price;
    public double size;
    public String color;

    @JsonAlias("category_id")
    public long categoryId;

    public ProductDTO(String name, String description, double price, long categoryId, double size, String color) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.size = size;
        this.color = color;
    }
}
