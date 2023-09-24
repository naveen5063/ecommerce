package com.example.productservice.thirdpartyclients.productservice;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {

    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto deleteProductId(Long id);
}
