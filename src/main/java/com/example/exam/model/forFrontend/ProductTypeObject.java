package com.example.exam.model.forFrontend;

import com.example.exam.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Setter
@Getter
public class ProductTypeObject {

    public ProductTypeObject(List<Product> products){
        this.products = products;
    }



    private List<Product> products;
    private Long id;
    private String name;
    private double price;
    private double weightGram;




}
