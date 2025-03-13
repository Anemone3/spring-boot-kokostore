package com.example.api_kokostore.application.service;

import com.example.api_kokostore.application.dto.product.CreateProductDto;
import com.example.api_kokostore.domain.entities.CategoriesEntity;
import com.example.api_kokostore.domain.entities.ProductEntity;
import com.example.api_kokostore.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service( "productService")
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }


    public List<ProductEntity> listProduct(){

        return productRepository.findAll();
    }

    @Transactional
    public ProductEntity saveProduct(CreateProductDto productDto){

        CategoriesEntity category = categoryService.createOrGetCategory(productDto.category());

        ProductEntity product = new ProductEntity();

        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        product.setCategory(category);
        product.setImage(productDto.image());
        product.setSku(productDto.sku());

        return productRepository.save(product);
    }
}
