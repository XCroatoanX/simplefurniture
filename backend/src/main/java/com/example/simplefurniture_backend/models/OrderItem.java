package com.example.simplefurniture_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private CustomOrder customOrder;

    private String productId;

    public OrderItem() {}

    public OrderItem(Long id, int quantity, CustomOrder customOrder, String productId) {
        this.id = id;
        this.quantity = quantity;
        this.customOrder = customOrder;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CustomOrder getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(CustomOrder customOrder) {
        this.customOrder = customOrder;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
