package com.example.simplefurniture_backend.dao;

import com.example.simplefurniture_backend.config.JWTUtil;
import com.example.simplefurniture_backend.dto.CustomOrderDTO;
import com.example.simplefurniture_backend.models.CustomOrder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomOrderDAO {
    private final CustomOrderRepository customOrderRepository;
    private final CustomUserRepository customUserRepository;
    private final OrderItemDAO orderItemDAO;
    private final JWTUtil jwtUtil;
    private final HttpServletRequest request;

    public CustomOrderDAO(CustomOrderRepository customOrderRepository, CustomUserRepository customUserRepository, OrderItemDAO orderItemDAO, JWTUtil jwtUtil, HttpServletRequest request) {
        this.customOrderRepository = customOrderRepository;
        this.customUserRepository = customUserRepository;
        this.orderItemDAO = orderItemDAO;
        this.jwtUtil = jwtUtil;
        this.request = request;
    }

    public List<CustomOrder> getAllCustomOrders() { return customOrderRepository.findAll(); }


    @Transactional
    public void createCustomOrder(CustomOrderDTO customOrderDTO) {
        CustomOrder customOrder = new CustomOrder();

    }
}
