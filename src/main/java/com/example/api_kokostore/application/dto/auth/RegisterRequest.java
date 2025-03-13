package com.example.api_kokostore.application.dto.auth;

public record RegisterRequest(
        String email,
        String password,
        String username
) {
}
