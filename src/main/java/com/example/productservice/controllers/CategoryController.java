package com.example.productservice.controllers;

import com.example.productservice.dtos.CategoryDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public Category getCategory(@PathVariable("uuid") String uuid){
        return categoryService.getCategory(uuid);
    }

    @GetMapping()
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
