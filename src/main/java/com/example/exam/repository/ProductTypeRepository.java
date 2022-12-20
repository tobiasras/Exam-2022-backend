package com.example.exam.repository;

import com.example.exam.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    List<ProductType> findProductTypesByNameStartingWith(String name);

    List<ProductType> findProductTypeByProductsIsNotNullAndNameStartingWith(String name);

}
