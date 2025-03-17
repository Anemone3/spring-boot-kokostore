package com.example.api_kokostore.application.controller;


import com.example.api_kokostore.application.dto.product.CreateProductDto;
import com.example.api_kokostore.application.dto.product.ResponseProduct;
import com.example.api_kokostore.application.service.ProductService;
import com.example.api_kokostore.domain.entities.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductEntity>> getProducts(){
        return ResponseEntity.ok(productService.listProduct());
    }


    @PreAuthorize( "hasAuthority('MANAGE_PRODUCTS')")
    @PostMapping
    public ResponseEntity<ResponseProduct> saveProduct(@RequestBody CreateProductDto productDto){
        var product = productService.saveProduct(productDto);
        ResponseProduct response = ResponseProduct.from(product);

        return ResponseEntity.ok(response);
    }
}
