package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository,
                                  CategoryRepository categoryRepository,
                                  PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    private static ProductDto convertToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice().getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getProductDtos(products);
    }

    @Override
    public ProductDto getProductById(String uuid) {
        Optional<Product> productOptional = productRepository.findByUuid(UUID.fromString(uuid));
        if (productOptional.isEmpty()) {
            return null;
        }
        Product product = productOptional.get();
        return convertToProductDto(product);
    }


    @Override
    public ProductDto createProduct(ProductDto product) {
        Product product1 = new Product();
        Category category = new Category();
        category.setName("nokia");
        Category savedCategory = categoryRepository.save(category);

        Price price = new Price("usd", product.getPrice());
        Price savedPrice = priceRepository.save(price);
        product1.setPrice(savedPrice);
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());
        product1.setImage(product.getImage());
        product1.setCategory(savedCategory);
        productRepository.save(product1);

        return convertToProductDto(product1);
    }

    @Override
    public ProductDto deleteProductId(String uuid) {
        Optional<Product> getProductOptional = productRepository.findByUuid(UUID.fromString(uuid));
        productRepository.deleteById(UUID.fromString(uuid));
        if (getProductOptional.isEmpty()) {
            return null;
        }
        Product product = getProductOptional.get();
        return convertToProductDto(product);
    }

    @Override
    public ProductDto updateProductById(ProductDto productDto, String uuid) {
        Optional<Product> productOptional = productRepository.findByUuid(UUID.fromString(uuid));
        if (productOptional.isEmpty()) {
            return null;
        }
        Product product = productOptional.get();
        product.setImage(productDto.getImage());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        productRepository.save(product);
        return convertToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProductsByCategoryId(String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();

        return getProductDtos(products);
    }

    private List<ProductDto> getProductDtos(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setPrice(product.getPrice().getPrice());
            productDtos.add(productDto);

        }
        return productDtos;
    }
}
