package com.example.simplefurniture_backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplefurniture_backend.models.Product;

//maps the product class to the database using the Long type as default of ID's
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByCategoryId(long id);
}
