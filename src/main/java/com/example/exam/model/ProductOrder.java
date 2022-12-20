package com.example.exam.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Entity
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "order")
    @JsonBackReference
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Delivery delivery;
}
