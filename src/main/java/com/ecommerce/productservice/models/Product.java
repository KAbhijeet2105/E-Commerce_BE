package com.ecommerce.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String imageUrl;
    private Category category;
}
