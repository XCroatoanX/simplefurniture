package com.example.simplefurniture_backend.controller;

import com.example.simplefurniture_backend.dao.CustomUserDAO;
import com.example.simplefurniture_backend.dto.CustomUserDTO;
import com.example.simplefurniture_backend.models.CustomUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://s1148519.student.inf-hsleiden.nl:18519" })
@RequestMapping("/customUser")
public class CustomUserController {
    private final CustomUserDAO customUserDAO;
    private final HttpServletRequest request;

    public CustomUserController(CustomUserDAO customUserDAO, HttpServletRequest request) {
        this.customUserDAO = customUserDAO;
        this.request = request;
    }
}
