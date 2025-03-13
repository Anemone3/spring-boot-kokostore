package com.example.api_kokostore.application.dto.auth;

public record AuthRequest(
        String email,
        String password
) {
}
