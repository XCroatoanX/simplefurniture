package com.example.simplefurniture_backend.services;

import java.util.Collections;

import com.example.simplefurniture_backend.dao.CustomUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.simplefurniture_backend.models.CustomUser;

@Service
public class UserService implements UserDetailsService {

    private final CustomUserRepository userDAO;

    public UserService(CustomUserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUser customUser = userDAO.findByEmail(email);

        return new User(
                email,
                customUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    // NEEDS IMPLEMENTATION: userRole
}
