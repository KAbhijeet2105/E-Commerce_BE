package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GenericProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

}
