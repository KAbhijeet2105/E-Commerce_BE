package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

     GenericProductDto getProductById(Long id);

     void getAllProducts();

    void deleteProductById(Long id);

    void createProduct(Product product);

    void updateProductById(Long id);

}
