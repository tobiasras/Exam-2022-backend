package com.example.exam.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // todo: create address checker
    // Ninna Jørgensen, Nørrebrogade 23, 2 tv, 2200 N"
    private String address;



    @OneToOne(mappedBy = "destination")
    private Delivery delivery;




}
