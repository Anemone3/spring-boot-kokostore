package com.example.api_kokostore.application.service;

import com.example.api_kokostore.domain.model.CategoriesEntity;
import com.example.api_kokostore.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoriesEntity createOrGetCategory(String nameCategory){

        if (nameCategory == null || nameCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede ser nulo o vacío");
        }

        return categoryRepository.findByName(nameCategory).orElseGet(()->{
            CategoriesEntity newCategory = new CategoriesEntity();
            newCategory.setName(nameCategory);
            return categoryRepository.save(newCategory);
        });
    }

}
