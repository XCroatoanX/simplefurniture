package com.example.simplefurniture_backend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.simplefurniture_backend.dto.CategoryDTO;
import com.example.simplefurniture_backend.models.Category;

@Component
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO) {
        this.categoryRepository.save(new Category(categoryDTO.name));
    }
}
