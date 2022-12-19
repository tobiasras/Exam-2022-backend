package com.example.exam.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_ID", referencedColumnName = "id")
    private Destination destination;


    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private Set<ProductOrder> orders = new HashSet<>();







}
