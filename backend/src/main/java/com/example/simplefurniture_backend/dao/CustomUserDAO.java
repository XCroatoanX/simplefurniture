package com.example.simplefurniture_backend.dao;

import com.example.simplefurniture_backend.config.JWTUtil;
import com.example.simplefurniture_backend.dto.CustomUserDTO;
import com.example.simplefurniture_backend.models.CustomUser;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDAO {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressDAO addressDAO;
    private final JWTUtil jwtUtil;

    public CustomUserDAO(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder, AddressDAO addressDAO, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressDAO = addressDAO;
        this.jwtUtil = jwtUtil;
    }

    public List<CustomUser> getAllCustomUsers() {
        return this.userRepository.findAll();
    }

    // NEED TO ASK HELP WITH THIS
//    public CustomUser getCustomUser(String userToken){
//        return this.userRepository.findByToken(userToken)
//    }


    @Transactional
    public void createCustomUser(CustomUserDTO customUserDTO) {
        CustomUser customUser = new CustomUser(customUserDTO.email, customUserDTO.password, customUserDTO.isAdmin, customUserDTO.address, customUserDTO.firstName, customUserDTO.lastName);
        this.userRepository.save(customUser);
    }

    @Transactional
    public void createCustomUser(CustomUser customUser){
        this.createCustomUser(customUser);
    }

}
