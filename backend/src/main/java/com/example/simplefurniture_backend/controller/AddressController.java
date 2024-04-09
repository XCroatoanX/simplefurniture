package com.example.simplefurniture_backend.controller;

import com.example.simplefurniture_backend.dao.AddressDAO;
import com.example.simplefurniture_backend.dto.AddressDTO;
import com.example.simplefurniture_backend.models.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://s1148519.student.inf-hsleiden.nl:18519"})
@RequestMapping("/address")
public class AddressController {
    private final AddressDAO addressDAO;

    public AddressController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(this.addressDAO.getAllAddresses());
    }

    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody AddressDTO addressDTO) {
        this.addressDAO.createAddress(addressDTO);
        return ResponseEntity.ok("Address created successfully");
    }
}
