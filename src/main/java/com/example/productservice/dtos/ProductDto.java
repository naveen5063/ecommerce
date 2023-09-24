package com.example.productservice.dtos;

import com.example.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String title;
    private String description;
    private String image;
    private double price;

}
