package com.example.exam.service;

import com.example.exam.model.Destination;
import com.example.exam.model.Product;
import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import com.example.exam.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.UnaryOperator;

@Service
@AllArgsConstructor
public class ProductOrderService implements CrudInterface<ProductOrder, Long>{

    private ProductOrderRepository productOrderRepository;
    private ProductService productService;
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


    public ProductOrder createOrder(List<ProductType> productTypeFromOrder, Destination destination) throws Exception {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setDestination(destination);

        ProductOrder productOrderAfterSave = save(productOrder);

        for (ProductType next : productTypeFromOrder) {
            List<Product> products = productService.getWithProductTypeIDWithNoDelivery(next);

            if (products.isEmpty()) {
                throw new Exception();
            } else {
                Product product = products.get(0);
                product.setOrder(productOrderAfterSave);
                productService.save(product);
            }
        }


        return findById(productOrderAfterSave.getId()).orElse(null);
    }
}
