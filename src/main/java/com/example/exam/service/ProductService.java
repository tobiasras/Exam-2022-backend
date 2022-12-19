package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.model.ProductType;
import com.example.exam.repository.ProductRepository;
import com.example.exam.repository.ProductTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@AllArgsConstructor
public class ProductService implements CrudInterface<Product, Long>{


    private ProductRepository productRepository;

    @Override
    public Set<Product> findAll() {
        return new HashSet<>(productRepository.findAll());
    }

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }
}
