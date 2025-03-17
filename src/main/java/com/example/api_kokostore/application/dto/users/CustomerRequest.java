package com.example.api_kokostore.application.dto.users;

public record CustomerRequest(
        String address,
        String city,
        String country,
        String state,
        String zipCode
) {
}
