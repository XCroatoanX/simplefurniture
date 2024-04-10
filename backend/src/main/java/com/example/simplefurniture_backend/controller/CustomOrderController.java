package com.example.simplefurniture_backend.controller;

import com.example.simplefurniture_backend.dao.CustomOrderDAO;
import com.example.simplefurniture_backend.dto.CustomOrderDTO;
import com.example.simplefurniture_backend.models.CustomOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://s1148519.student.inf-hsleiden.nl:18519" })
@RequestMapping("/orders")
public class CustomOrderController {
    private final CustomOrderDAO customOrderDAO;

    public CustomOrderController(CustomOrderDAO customOrderDAO) {
        this.customOrderDAO = customOrderDAO;
    }

    @GetMapping
    public ResponseEntity<List<CustomOrder>> getAllCustomOrders(){
        return ResponseEntity.ok(this.customOrderDAO.getAllCustomOrders());
    }

    @PostMapping
    public ResponseEntity<String> createCustomOrder(@RequestBody CustomOrderDTO customOrderDTO){
        this.customOrderDAO.createCustomOrder(customOrderDTO);
        return ResponseEntity.ok("Order Successfully Added");
    }
    // NEEDS REVIEW
}
