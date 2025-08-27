package com.ecommerce.productservice.thirdPartyClients.fakestoreClient;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {


    // private final ProductService productService;
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreUrl;

    @Value("${fakestore.api.paths.products}")
    private String pathForProducts;
    private  String specificProductUrl;
    private  String genericProductUrl;


    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                    @Value("${fakestore.api.url}") String fakeStoreUrl,
                    @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.genericProductUrl = fakeStoreUrl + pathForProducts;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //integrate the fakestore api
        //rest template
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        //convert fakestore product dto to generic product dto before return

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("product with id : "+id+" doesn't exist.");
        }

        return fakeStoreProductDto;
        //return convertToGenericProductDto(fakeStoreProductDto);
    }


    public List<FakeStoreProductDto> getAllProducts() {


        System.out.println("inside getAllProducts " + genericProductUrl);

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        assert responseEntity.getBody() != null;
        return List.of(responseEntity.getBody());
        //TODO: Read more about Java Erasure. (generic type backward comp. and all)
//        List<GenericProductDto> result = new ArrayList<>();
//        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
//
//        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
//            result.add(convertToGenericProductDto(fakeStoreProductDto));
//        }
//
//        return fakeStoreProductDtos;
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        return null;
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        System.out.println("inside FakeStoreProductService .. createProduct..." + genericProductDto);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();
//        GenericProductDto result = convertToGenericProductDto(responseEntity.getBody());
//
//        return result;
    }


    public FakeStoreProductDto updateProductById(Long id) {
        return null;
    }

}
