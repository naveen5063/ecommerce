package com.example.productservice.inheritancedemo.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends User {
    private double averageRating;
}
