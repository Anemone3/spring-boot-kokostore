package com.example.api_kokostore.config.models;

import com.example.api_kokostore.domain.enums.Roles;

public record JwtPayload(
        String sub,
        String email,
        Roles role
) {
}
