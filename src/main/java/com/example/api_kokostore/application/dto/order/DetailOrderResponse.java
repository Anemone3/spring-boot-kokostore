package com.example.api_kokostore.application.dto.order;

public record DetailOrderResponse(
                Long productId,
                String description,
                int quantity,
                double price,
                double subtotal) {
}