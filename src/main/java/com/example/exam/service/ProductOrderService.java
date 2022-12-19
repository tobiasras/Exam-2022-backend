package com.example.exam.service;

import com.example.exam.model.ProductOrder;
import com.example.exam.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@AllArgsConstructor
public class ProductOrderService implements CrudInterface<ProductOrder, Long>{

    private ProductOrderRepository productOrderRepository;


    @Override
    public Set<ProductOrder> findAll() {
        return new HashSet<>(productOrderRepository.findAll());
    }

    @Override
    public ProductOrder save(ProductOrder object) {
        return productOrderRepository.save(object);
    }

    @Override
    public void delete(ProductOrder object) {
        productOrderRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        productOrderRepository.deleteById(aLong);
    }

    @Override
    public Optional<ProductOrder> findById(Long aLong) {
        return productOrderRepository.findById(aLong);
    }
}
