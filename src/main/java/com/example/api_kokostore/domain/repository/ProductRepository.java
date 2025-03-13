package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
