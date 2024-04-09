package com.example.simplefurniture_backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ProductDTO {
    public String name;
    public String description;
    public double price;
    public String imgUrl;
    public int stock;

    @JsonAlias("category_id")
    public long categoryId;

    public ProductDTO(String name, String description, double price, long categoryId, int stock, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.imgUrl = imgUrl;
        this.stock = stock;
    }
}
