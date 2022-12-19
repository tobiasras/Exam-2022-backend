package com.example.exam.service;


import com.example.exam.model.Product;
import com.example.exam.model.ProductType;
import com.example.exam.repository.ProductRepository;
import com.example.exam.repository.ProductTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProductTypeService implements CrudInterface<ProductType, Long>{

    private ProductTypeRepository productRepository;

    @Override
    public Set<ProductType> findAll() {
        return new HashSet<>(productRepository.findAll());
    }

    @Override
    public ProductType save(ProductType object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(ProductType object) {
        productRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public Optional<ProductType> findById(Long aLong) {
        return productRepository.findById(aLong);
    }
}
