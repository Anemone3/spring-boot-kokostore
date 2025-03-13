package com.example.api_kokostore.application.dto.users;

import com.example.api_kokostore.domain.enums.AuthProviderEnum;
import com.example.api_kokostore.domain.enums.Roles;

public record UserResponse(
        String id,
        String username,
        String email,
        Roles role,
        String profile,
        AuthProviderEnum provider
) {
}
