package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

     GenericProductDto getProductById(Long id);

     List<GenericProductDto> getAllProducts();

    void deleteProductById(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProductById(Long id);

}
