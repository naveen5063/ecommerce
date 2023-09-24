package com.example.productservice.services;

import com.example.productservice.dtos.CategoryDto;
import com.example.productservice.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category getCategory(String uuid);

    List<CategoryDto> getAllCategories();
}
