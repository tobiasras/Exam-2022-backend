package com.example.exam.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;



@Setter
@Getter
public class ProductTypeWithProducts{

    public ProductTypeWithProducts(List<Product> products){
        this.products = products;
    }

    private List<Product> products;
    private Long id;
    private String name;
    private double price;
    private double weightGram;




}
