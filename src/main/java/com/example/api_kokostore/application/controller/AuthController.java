package com.example.api_kokostore.application.controller;


import com.example.api_kokostore.application.dto.auth.AuthRequest;
import com.example.api_kokostore.application.dto.auth.AuthResponse;
import com.example.api_kokostore.application.dto.auth.RegisterRequest;
import com.example.api_kokostore.application.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request, HttpServletResponse res){
        AuthResponse response = authService.login(res, request.email(), request.password());

        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request, HttpServletResponse res){
        AuthResponse response = authService.register(res, request);

        return ResponseEntity.ok(response);
    }


}
