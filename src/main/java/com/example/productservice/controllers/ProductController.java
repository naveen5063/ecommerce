package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/products")
public class ProductController {
//    @Autowired
//    Field Injection
    private ProductService productService;

//    Controller Injection
//public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
    public ProductController(ProductService productService){
        this.productService = productService;
    }

//  Setter Injection
//  @Autowired
//public void setProductService(ProductService productService){
//        this.productService = productService;
//}
    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getAllProductsByCategoryId/{id}")
    public List<ProductDto> getAllProductsByCategoryId(@PathVariable("id") String uuid) throws NotFoundException {
        return productService.getAllProductsByCategoryId(uuid);
    }

    @GetMapping("{id}")
    public ProductDto getProductById(@PathVariable("id") String uuid) throws NotFoundException {
        return productService.getProductById(uuid);
    }

    @DeleteMapping("{id}")
    public ProductDto deleteProductById(@PathVariable("id") String uuid){
        return productService.deleteProductId(uuid);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product){
        return productService.createProduct(product);
//        return "Created new product " + product.getTitle();
    }

    @PutMapping("{id}")
    public ProductDto updateProductById(@RequestBody ProductDto productDto,
                                        @PathVariable("id") String uuid){
        return productService.updateProductById(productDto, uuid);
    }

//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
//        return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                                    HttpStatus.NOT_FOUND);
////        System.out.println("Not found exception happened");
//    }

}
