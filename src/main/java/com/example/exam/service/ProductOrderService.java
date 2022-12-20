package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import com.example.exam.model.forFrontend.ProductObject;
import com.example.exam.model.forFrontend.ProductOrderObject;
import com.example.exam.model.forFrontend.ProductTypeObject;
import com.example.exam.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductOrderService implements CrudInterface<ProductOrder, Long> {

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

    public Set<ProductOrderObject> productOrderObjectFromOrders(Set<ProductOrder> all) {

        Set<ProductOrderObject> message = new HashSet<>();
        // creates for each order
        for (ProductOrder productOrder : all) {
            ProductOrderObject order = new ProductOrderObject();


            List<ProductObject> listProject = new ArrayList<>();
            ProductOrder next = productOrder;

            order.setId(next.getId());


            List<Product> withOrderID = productService.getWithOrderID(next.getId());

            // for each product in order
            for (Product product : withOrderID) {
                ProductObject productObject = new ProductObject();

                Product next1 = product;

                ProductType productType = next1.getType();

                ProductTypeObject productTypeWithProducts = new ProductTypeObject();
                productTypeWithProducts.setName(productType.getName());
                productTypeWithProducts.setWeightGram(productType.getWeightGram());
                productTypeWithProducts.setId(productType.getId());
                productTypeWithProducts.setPrice(productType.getPrice());


                productObject.setProductType(productTypeWithProducts);
                productObject.setId(next1.getId());

                listProject.add(productObject);
            }


            order.setProducts(listProject);
            message.add(order);
        }


        return message;
    }


    public ProductOrder createOrder(List<ProductType> productTypeFromOrder) throws Exception {
        ProductOrder productOrder = new ProductOrder();

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
