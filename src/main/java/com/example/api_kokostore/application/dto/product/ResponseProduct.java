package com.example.api_kokostore.application.dto.product;

import com.example.api_kokostore.domain.model.CategoriesEntity;
import com.example.api_kokostore.domain.model.ProductEntity;

public record ResponseProduct(
        long id,
        String name,
        double price,
        String description,
        String image,
        CategoriesEntity category
) {
    public static ResponseProduct from(ProductEntity product) {
        return new ResponseProduct(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getImage(),
                product.getCategory()
        );
    }
}
