package com.example.api_kokostore.application.dto.users;



public record CustomerResponse(
        Long id,
        String address,
        String city,
        String country,
        String state,
        String zipCode
) {



}
