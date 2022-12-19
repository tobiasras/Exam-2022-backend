package com.example.testeksamen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Race {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
