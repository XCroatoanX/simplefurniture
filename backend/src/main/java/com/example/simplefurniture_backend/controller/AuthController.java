package com.example.simplefurniture_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.simplefurniture_backend.config.JWTUtil;
import com.example.simplefurniture_backend.dao.CustomUserRepository;
import com.example.simplefurniture_backend.dto.AuthenticationDTO;
import com.example.simplefurniture_backend.dto.LoginResponse;
import com.example.simplefurniture_backend.models.CustomUser;
import com.example.simplefurniture_backend.services.CredentialValidator;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://s1148519.student.inf-hsleiden.nl:18519" })
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserRepository userDAO;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private CredentialValidator validator;

    public AuthController(CustomUserRepository userDAO, JWTUtil jwtUtil, AuthenticationManager authManager,
                          PasswordEncoder passwordEncoder, CredentialValidator validator) {
        this.userDAO = userDAO;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
        if (!validator.isValidEmail(authenticationDTO.email)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid email provided");
        }

        if (!validator.isValidPassword(authenticationDTO.password)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid password provided");
        }

        CustomUser customUser = userDAO.findByEmail(authenticationDTO.email);

        if (customUser != null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Can not register with this email");
        }
        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);
        CustomUser registeredCustomUser = new CustomUser(authenticationDTO.email, encodedPassword,
                authenticationDTO.isAdmin, authenticationDTO.address, authenticationDTO.firstName,
                authenticationDTO.lastName);
        userDAO.save(registeredCustomUser);
        String token = jwtUtil.generateToken(registeredCustomUser.getEmail());
        LoginResponse loginResponse = new LoginResponse(registeredCustomUser.getEmail(), token);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationDTO body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.email,
                    body.password);

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.email);

            CustomUser customUser = userDAO.findByEmail(body.email);
            LoginResponse loginResponse = new LoginResponse(customUser.getEmail(), token);

            return ResponseEntity.ok(loginResponse);

        } catch (AuthenticationException authExc) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "No valid credentials");
        }
    }

}
