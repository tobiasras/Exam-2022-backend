package com.example.exam.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private Set<ProductOrder> orders = new HashSet<>();

    private String wareHouse;


    // 04/02/2022
    private String date;





}
