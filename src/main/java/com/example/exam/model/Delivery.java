package com.example.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ProductOrder> orders = new HashSet<>();

    private String wareHouse;

    // 04/02/2022
    private String date;

}
