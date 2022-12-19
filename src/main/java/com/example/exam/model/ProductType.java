package com.example.exam.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // todo unique name
    private String name;

    private double price;
    // form grams
    private double weightGram;

    @OneToMany(mappedBy = "type" ,cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}
