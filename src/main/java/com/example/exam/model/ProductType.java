package com.example.exam.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    // form grams
    private double weightGram;

    private int inStock;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}
