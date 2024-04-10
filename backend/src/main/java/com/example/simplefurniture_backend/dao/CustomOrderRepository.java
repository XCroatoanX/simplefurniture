package com.example.simplefurniture_backend.dao;

import com.example.simplefurniture_backend.models.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomOrderRepository extends JpaRepository<CustomOrder, Long> {

}
