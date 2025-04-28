package com.example.api_kokostore.application.dto.users;

import com.example.api_kokostore.domain.entities.UserEntity;
import com.example.api_kokostore.domain.enums.AuthProviderEnum;
import com.example.api_kokostore.domain.enums.Roles;

import java.time.LocalDateTime;


public record UserResponse(
        String id,
        String username,
        String email,
        Roles role,
        String profile,
        AuthProviderEnum provider,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        CustomerResponse customer
) {
    public  static UserResponse from(UserEntity user) {
        return new UserResponse(
                user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getProfileImage(),
                user.getProvider(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getCustomer() != null ? new CustomerResponse(
                        user.getCustomer().getId(),
                        user.getCustomer().getAddress(),
                        user.getCustomer().getCity(),
                        user.getCustomer().getCountry(),
                        user.getCustomer().getState(),
                        user.getCustomer().getZipCode()
                ) : null
        );
    }
}
