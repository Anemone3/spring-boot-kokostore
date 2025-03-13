package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.CategoriesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoriesEntity,Long> {
    Optional<CategoriesEntity> findByName(String name);
}
