package com.example.exam.service;


import com.example.exam.model.ProductType;
import com.example.exam.repository.ProductRepository;
import com.example.exam.repository.ProductTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProductTypeService implements CrudInterface<ProductType, Long>{

    private ProductTypeRepository productTypeRepository;


    @Override
    public Set<ProductType> findAll() {
        return new HashSet<>(productTypeRepository.findAll());
    }

    public List<ProductType> findProductTypesByName(String nameSearch){
        return productTypeRepository.findProductTypesByNameStartingWith(nameSearch);
    }


    public List<ProductType> SearchNameProductTypeWithProducts(String name){
        return productTypeRepository.findProductTypeByProductsIsNotNullAndNameStartingWith(name);

    }


    @Override
    public ProductType save(ProductType object) {
        return productTypeRepository.save(object);
    }

    @Override
    public void delete(ProductType object) {
        productTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productTypeRepository.deleteById(aLong);
    }

    @Override
    public Optional<ProductType> findById(Long aLong) {

        return productTypeRepository.findById(aLong);
    }
}
