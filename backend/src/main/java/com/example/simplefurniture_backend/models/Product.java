package com.example.simplefurniture_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private String description;
    private double size;
    private String color;

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

    public Product(String name, String description, double price, double size, String color, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.size = size;
        this.color = color;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
