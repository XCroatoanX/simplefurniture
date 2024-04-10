package com.example.simplefurniture_backend.dao;

import com.example.simplefurniture_backend.dto.OrderItemDTO;
import com.example.simplefurniture_backend.models.CustomOrder;
import com.example.simplefurniture_backend.models.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderItemDAO {
    private final ProductRepository productRepository;
    private final CustomOrderRepository customOrderRepository;

    public OrderItemDAO(ProductRepository productRepository, CustomOrderRepository customOrderRepository) {
        this.productRepository = productRepository;
        this.customOrderRepository = customOrderRepository;
    }

    public void createOrderItem(OrderItemDTO orderItemDTO) {
        // NEEDS REVIEW
        Optional<Product> product = this.productRepository.findById(orderItemDTO.productId);
        Optional<CustomOrder> customOrder = this.customOrderRepository.findById(orderItemDTO.productId);
    }
}
