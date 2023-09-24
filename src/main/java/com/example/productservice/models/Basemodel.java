package com.example.productservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class Basemodel {
    @Id
    @GeneratedValue(generator = "naman")
    @GenericGenerator(name = "naman", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;
}
