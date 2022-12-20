package com.example.exam.controller;

import com.example.exam.model.Destination;
import com.example.exam.model.ProductOrder;
import com.example.exam.model.ProductType;
import com.example.exam.service.ProductOrderService;
import com.example.exam.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
public class OrderController {

    private ProductOrderService productOrderService;

    @PostMapping("api/post/create/ProductOrder")
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody List<ProductType> productsFromOrder, @RequestParam String destination) {


        Destination destinationModel = new Destination();
        destinationModel.setAddress(destination);


        try {
            ProductOrder order = productOrderService.createOrder(productsFromOrder, destinationModel);

            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(new ProductOrder(), HttpStatus.NOT_FOUND);
        }



    }
}