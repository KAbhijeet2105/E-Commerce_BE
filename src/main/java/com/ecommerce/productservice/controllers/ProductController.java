package com.ecommerce.productservice.controllers;
import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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


    public void getAllProducts(){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }


    public void createProduct(){

    }

    @PutMapping("/{id}")
    public void updateProductById(){

    }


    @GetMapping("/")
    public String helloProduct(){
        return "Hello World from Spring Boot! product service.";
    }


}
