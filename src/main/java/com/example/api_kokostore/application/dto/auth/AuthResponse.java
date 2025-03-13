package com.example.api_kokostore.application.dto.auth;

import com.example.api_kokostore.application.dto.users.UserResponse;

public record AuthResponse(
        UserResponse user,
        String accessToken
) {
}
