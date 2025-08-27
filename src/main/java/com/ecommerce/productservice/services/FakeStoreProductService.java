package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.thirdPartyClients.fakestoreClient.FakeStoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImageUrl(fakeStoreProductDto.getImage());

        return genericProductDto;
    }


    private FakeStoreClient fakeStoreClient;

FakeStoreProductService(FakeStoreClient fakeStoreClient){
    this.fakeStoreClient = fakeStoreClient;
}


    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {

        return convertToGenericProductDto(fakeStoreClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = (fakeStoreClient.getAllProducts());
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            GenericProductDto genericProductDto = convertToGenericProductDto(fakeStoreProductDto);
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
}

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
      return convertToGenericProductDto(fakeStoreClient.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id) {
        return convertToGenericProductDto(fakeStoreClient.updateProductById(id));
    }
}
