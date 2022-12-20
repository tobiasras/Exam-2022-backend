package com.example.exam.controller;

import com.example.exam.model.Product;
import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import com.example.exam.model.forFrontend.ProductObject;
import com.example.exam.model.forFrontend.ProductOrderObject;
import com.example.exam.model.forFrontend.ProductTypeObject;
import com.example.exam.service.ProductOrderService;
import com.example.exam.service.ProductService;
import com.example.exam.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@AllArgsConstructor
@RestController
public class OrderController {

    private ProductOrderService productOrderService;
    private ProductTypeService productTypeService;
    private ProductService productService;

    @PostMapping("api/post/create/ProductOrder")
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody List<ProductType> productsFromOrder, @RequestParam String destination) {

        try {
            ProductOrder order = productOrderService.createOrder(productsFromOrder);

            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(new ProductOrder(), HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping("api/get/fetch/by/productOrderID")
    public ResponseEntity<List<Product>> fetchProductOrderByID(@RequestParam Long orderID) {

        List<Product> withOrderID = productService.getWithOrderID(orderID);

        return new ResponseEntity<>(withOrderID, HttpStatus.OK);
    }



    @GetMapping("api/get/fetch/all/ProductOrder")
    public ResponseEntity<Set<ProductOrderObject>> fetchProductOrder() {

        Set<ProductOrder> all = productOrderService.findAll();

        return new ResponseEntity<>(productOrderService.productOrderObjectFromOrders(all), HttpStatus.OK);
    }

}