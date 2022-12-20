package com.example.exam.repository;

import com.example.exam.model.Product;
import com.example.exam.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByTypeAndOrderIsNull(ProductType productType);


}
