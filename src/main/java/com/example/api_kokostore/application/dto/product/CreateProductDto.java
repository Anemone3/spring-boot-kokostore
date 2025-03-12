package com.example.api_kokostore.application.dto.product;

public record CreateProductDto(
        String description,
        String name,
        String image,
        Double price,
        String sku,
        String category
) {
}
