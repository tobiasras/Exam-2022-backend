package com.example.exam.repository;

import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

}
