package com.example.simplefurniture_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplefurniture_backend.models.CustomUser;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findByEmail(String email);
}
