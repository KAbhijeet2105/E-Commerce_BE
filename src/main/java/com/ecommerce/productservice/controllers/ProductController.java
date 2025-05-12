package com.ecommerce.productservice.controllers;
import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    //@Autowired OPTIONAL
    //constructor injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return  productService.getProductById(id);
    }


    @GetMapping("/")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }


    @PostMapping("/createProduct")
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        System.out.println("got the create product request inside controller..."+genericProductDto);
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/{id}")
    public void updateProductById(){

    }


    @GetMapping("/baseurl")
    public String helloProduct(){
        return "Hello World from Spring Boot! product service.";
    }


}
