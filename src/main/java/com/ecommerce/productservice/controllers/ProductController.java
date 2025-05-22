package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.ExceptionDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return  productService.getProductById(id);
    }


    @GetMapping("/")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return null;
    }


    @PostMapping("/createProduct")
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        System.out.println("got the create product request inside controller..."+genericProductDto);
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/updateProduct/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id){
        return null;
    }


    @GetMapping("/baseurl")
    public String helloProduct(){
        return "Hello World from Spring Boot! product service.";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(ex.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        System.out.println("Got product not found exception. "+ex.getMessage());
        return exceptionDto;
    }


}
