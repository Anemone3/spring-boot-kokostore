package com.example.api_kokostore.application.dto.order;

public record PayloadProduct(
        Long id,
        double price,
        int quantity
) {
}
