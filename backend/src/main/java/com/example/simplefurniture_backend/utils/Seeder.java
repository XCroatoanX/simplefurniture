package com.example.simplefurniture_backend.utils;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.simplefurniture_backend.dao.ProductDAO;
import com.example.simplefurniture_backend.dao.UserRepository;
import com.example.simplefurniture_backend.models.Category;
import com.example.simplefurniture_backend.models.CustomUser;
import com.example.simplefurniture_backend.models.Product;

@Component
public class Seeder {
    private ProductDAO productDAO;
    private UserRepository userRepository;

    public Seeder(ProductDAO productDAO, UserRepository userRepository) {
        this.productDAO = productDAO;
        this.userRepository = userRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.seedProducts();
        this.seedUser();
    }

    private void seedProducts() {
        Category category = new Category("Apple Products");
        Product product1 = new Product("AirPods", "The latest and greatest", 249.95, 0, "white", category);
        Product product2 = new Product("iPad Pro", "Now with a bigger screen!", 799, 0, "space grey", category);
        this.productDAO.createProduct(product1);
        this.productDAO.createProduct(product2);
    }

    private void seedUser() {
        CustomUser customUser = new CustomUser();
        customUser.setEmail("test@mail.com");
        customUser.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        customUser.setRole("admin");
        userRepository.save(customUser);
    }
}
