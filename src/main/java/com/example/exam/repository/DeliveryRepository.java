package com.example.exam.repository;

import com.example.exam.model.Delivery;
import com.example.exam.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
