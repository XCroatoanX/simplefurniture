package com.example.simplefurniture_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class CustomOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date orderDate;
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private CustomUser customUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Address address;

    public CustomOrder() {
    }

    public CustomOrder(UUID id, Date orderDate, CustomUser customUser, double totalPrice, Address address) {
        this.id = id;
        this.orderDate = orderDate;
        this.customUser = customUser;
        this.totalPrice = totalPrice;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
