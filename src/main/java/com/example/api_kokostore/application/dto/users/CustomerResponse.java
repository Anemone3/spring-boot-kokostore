package com.example.api_kokostore.application.dto.users;

import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String address,
        String city,
        String country,
        String state,
        String zipCode
) {



}
