//package com.example.productservice.services;
//
//import com.example.productservice.dtos.GenericProductDto;
//import com.example.productservice.exceptions.NotFoundException;
//import com.example.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
//import com.example.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Primary default dependency injection
//@Service("fakeStoreProductService")
//public class FakeStoreProductService implements ProductService {
//
//    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
//
//    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
//        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
//    }
//
//    private GenericProductDto convertFakeStoreToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
//        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProductDto.getId());
//        product.setImage(fakeStoreProductDto.getImage());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        product.setCategory(fakeStoreProductDto.getCategory());
//        return product;
//    }
//
//    public GenericProductDto createProduct(GenericProductDto product) {
//        return convertFakeStoreToGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
//    }
//
//    @Override
//    public GenericProductDto deleteProductId(Long id) {
//        return convertFakeStoreToGenericProductDto(fakeStoreProductServiceClient.deleteProductId(id));
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//
//        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
//            genericProductDtos.add(convertFakeStoreToGenericProductDto(fakeStoreProductDto));
//        }
//        return genericProductDtos;
//    }
//
//    public GenericProductDto getProductById(Long id) throws NotFoundException {
//        return convertFakeStoreToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
//    }
//}
