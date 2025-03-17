package com.example.api_kokostore.application.dto.auth;

import com.example.api_kokostore.application.dto.users.UserResponse;
import com.example.api_kokostore.domain.entities.UserEntity;

public record AuthResponse(
        UserResponse user,
        String accessToken
) {
    public static AuthResponse fromUser(UserEntity user, String accessToken) {
        return new AuthResponse(UserResponse.from(user),accessToken);
    }
}
