package com.ecommerce.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel {
    private Long id;
    private String name;

}
