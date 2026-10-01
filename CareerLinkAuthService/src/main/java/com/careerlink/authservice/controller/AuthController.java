package com.careerlink.authservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerlink.authservice.dto.AuthRequest;
import com.careerlink.authservice.dto.AuthResponse;
import com.careerlink.authservice.dto.RegisterRequest;
import com.careerlink.authservice.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(
                "CareerLink Auth Service is running successfully on port 8081"
        );
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {

        if (request == null || isBlank(request.getEmail())
                || isBlank(request.getPassword()) || isBlank(request.getRole())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {

        if (request == null || isBlank(request.getEmail())
                || isBlank(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}