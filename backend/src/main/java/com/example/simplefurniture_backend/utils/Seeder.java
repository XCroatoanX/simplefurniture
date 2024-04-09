package com.example.simplefurniture_backend.utils;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.simplefurniture_backend.dao.AddressDAO;
import com.example.simplefurniture_backend.dao.CategoryRepository;
import com.example.simplefurniture_backend.dao.ProductDAO;
import com.example.simplefurniture_backend.dao.UserRepository;
import com.example.simplefurniture_backend.models.Address;
import com.example.simplefurniture_backend.models.Category;
import com.example.simplefurniture_backend.models.CustomUser;
import com.example.simplefurniture_backend.models.Product;

@Component
public class Seeder {
        private ProductDAO productDAO;
        private UserRepository userRepository;
        private CategoryRepository categoryRepository;
        private AddressDAO addressDAO;

        public Seeder(ProductDAO productDAO, UserRepository userRepository, CategoryRepository categoryRepository,
                        AddressDAO addressDAO) {
                this.productDAO = productDAO;
                this.userRepository = userRepository;
                this.categoryRepository = categoryRepository;
                this.addressDAO = addressDAO;
        }

        @EventListener
        public void seed(ContextRefreshedEvent event) {
                this.seedProducts();
                this.seedUser();
        }

        private void seedProducts() {
                Category category = new Category("Furniture");

                Product furniture1 = new Product("Sofa", "Comfortable and stylish sofa for your living room", 299.99,
                                category,
                                60,
                                "https://www.ikea.com/nl/en/images/products/parup-2-seat-sofa-gunnared-dark-grey__1041901_pe841181_s5.jpg");
                Product furniture2 = new Product("Dining Table", "Elegant dining table for family gatherings", 2799.99,
                                category, 270,
                                "https://woodlandcreekfurniture.com/media/amasty/webp/catalog/product/cache/019ce3a6ee29536245b2502ea1c3bc26/w/c/wcf-9527-edit_jpg.webp");
                Product furniture3 = new Product("Bed Frame", "Sturdy bed frame for a good night's sleep", 1299.99,
                                category,
                                250,
                                "https://www.webshop-outlet.nl/wp-content/uploads/2023/10/Adore-Designbed-Beige.jpg");
                Product furniture4 = new Product("Bookshelf", "Organize your books with this spacious bookshelf",
                                138.00,
                                category, 50,
                                "https://images-cdn.ubuy.co.in/634005ced6d2d86e2476d69d-artswish-tree-bookshelf-5-shelf-floor.jpg");
                Product furniture5 = new Product("Coffee Table", "Modern coffee table for your living room", 110.99,
                                category,
                                70, "https://m.media-amazon.com/images/I/91cX-cB6L5L.jpg");
                Product furniture6 = new Product("Desk", "Functional desk for your home office", 74.95, category, 120,
                                "https://www.ikea.com/nl/en/images/products/micke-desk-black-brown__0735981_pe740299_s5.jpg");
                Product furniture7 = new Product("Armchair", "Cozy armchair for relaxation", 450.00, category, 0,
                                "https://www.ikea.com/nl/en/images/products/vimle-armchair-gunnared-beige__1068011_pe852869_s5.jpg?f=s");
                Product furniture8 = new Product("TV Stand", "Sleek TV stand to complement your entertainment setup",
                                571.00,
                                category, 139,
                                "https://images-cdn.ubuy.co.in/634e414b3cd45951796ab09c-modern-tv-stand-entertainment-center.jpg");
                Product furniture9 = new Product("Wardrobe", "Spacious wardrobe for storing clothes", 249.99, category,
                                0,
                                "https://www.ikea.com/nl/en/images/products/hauga-wardrobe-with-sliding-doors-white__0931942_pe791324_s5.jpg");
                Product furniture10 = new Product("Side Table", "Compact side table for your bedroom or living room",
                                275.00,
                                category, 65,
                                "https://d.media.kavehome.com/image/upload/w_900,c_fill,ar_0.8,g_auto/v1709212220/ambiences/A000001884_2.jpg");

                this.productDAO.createProduct(furniture2);
                this.productDAO.createProduct(furniture3);
                this.productDAO.createProduct(furniture1);
                this.productDAO.createProduct(furniture4);
                this.productDAO.createProduct(furniture5);
                this.productDAO.createProduct(furniture6);
                this.productDAO.createProduct(furniture7);
                this.productDAO.createProduct(furniture8);
                this.productDAO.createProduct(furniture9);
                this.productDAO.createProduct(furniture10);
        }

        private void seedUser() {
                Address address = new Address();
                address.setCity("Den Haag");
                address.setCountry("Nederland");
                address.setstreet("Perenstraat 96");
                address.setZipCode("2584AN");
                this.addressDAO.createAddress(address);

                CustomUser customUser = new CustomUser();
                customUser.setEmail("test@mail.com");
                customUser.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
                customUser.setAdmin(true);
                customUser.setAdress(address);
                customUser.setfirstName("Artem");
                customUser.setlastName("Stasyuk");
                userRepository.save(customUser);
        }
}
