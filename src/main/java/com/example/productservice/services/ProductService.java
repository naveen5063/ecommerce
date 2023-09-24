package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(String uuid) throws NotFoundException;

    ProductDto createProduct(ProductDto product);

    ProductDto deleteProductId(String uuid);

    ProductDto updateProductById(ProductDto productDto, String uuid);

    List<ProductDto> getAllProductsByCategoryId(String uuid);
}
