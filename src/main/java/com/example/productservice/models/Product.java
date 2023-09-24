package com.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Basemodel {
    private String title;
    private String description;
    private String image;

    @ManyToOne
    private Category category;

    @OneToOne
    private Price price;
}