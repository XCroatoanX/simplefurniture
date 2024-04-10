package com.example.simplefurniture_backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OrderItemDTO {
    @JsonAlias("order_id")
    public long orderId;

    public int quantity;
    public long productId;

    public OrderItemDTO(long orderId, int quantity, long productId) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.productId = productId;
    }
}
