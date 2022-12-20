package com.example.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @EqualsAndHashCode.Exclude
    private ProductType type;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private ProductOrder order;
}

