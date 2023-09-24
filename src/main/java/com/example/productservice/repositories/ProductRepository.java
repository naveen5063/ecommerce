package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, UUID> {

    Optional<Product> findByUuid(UUID uuid);

    void deleteById(UUID uuid);

    @Override
    <S extends Product> S save(S entity);

    List<Product> findAll();
}
