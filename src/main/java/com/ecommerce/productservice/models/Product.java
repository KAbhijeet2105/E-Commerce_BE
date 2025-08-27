package com.ecommerce.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private int price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}


/*
*  Category isn't a primitive attribute , its a relation
* Product ---> Category Cardinality
*        1              1
*      PRODUCT ----- CATEGORY
*        M               1
*
*
* */