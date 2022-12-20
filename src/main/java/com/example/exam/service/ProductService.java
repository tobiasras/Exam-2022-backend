package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import com.example.exam.model.forFrontend.ProductObject;
import com.example.exam.model.forFrontend.ProductOrderObject;
import com.example.exam.model.forFrontend.ProductTypeObject;
import com.example.exam.repository.ProductRepository;
import com.example.exam.repository.ProductTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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


    public List<Product> getWithProductTypeIDWithNoDelivery(ProductType productType){
        return productRepository.getProductsByTypeAndOrderIsNull(productType);
    }



    public List<Product> getWithOrderID(Long orderID){
        return productRepository.findProductByOrder_Id(orderID);
    }


    public void addStock(ProductType productType, int amount) {

        for (int i = 0; i < amount; i++) {
            Product product = new Product();
            product.setType(productType);

            productRepository.save(product);
        }



    }
}
