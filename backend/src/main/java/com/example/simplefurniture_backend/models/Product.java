package com.example.simplefurniture_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double price;
    private String description;
    private int stock;
    private String imgUrl;

    private boolean isFinished = false;

    /*
     * Maps the many-to-one relationship between product and category,
     * jsonbackreference so that we do not get an
     * infinite dependency loop in the request. Cascasdetype merge so the product is
     * able to create a category if we
     * seed the data to the database. Without the merge you get a persistence race
     * condition.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Category category;

    // needed by JPA to create the entity must be present no arg constructor
    public Product() {
    }

    public Product(String name, String description, double price, Category category, int stock, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.imgUrl = imgUrl;
    }

    // getters and setters are needed to map all the properties to the database by
    // JPA, could
    // also be solved by making the properties public but gives less control over
    // the properties.
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getImgUrl() { return imgUrl; }

    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
}
