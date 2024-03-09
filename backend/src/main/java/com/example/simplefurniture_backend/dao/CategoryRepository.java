package com.example.simplefurniture_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplefurniture_backend.models.Category;

//maps the category class to the database using the Long type as default of ID's
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

