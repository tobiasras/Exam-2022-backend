package com.example.exam.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Delivery delivery;

}
