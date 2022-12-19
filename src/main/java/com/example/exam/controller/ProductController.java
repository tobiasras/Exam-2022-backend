package com.example.exam.controller;


import com.example.exam.model.ProductType;
import com.example.exam.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@AllArgsConstructor
@RestController
public class ProductController {

    private ProductTypeService productTypeService;

    @PostMapping("api/post/create/productType")
    public ResponseEntity<String> createProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);

        return new ResponseEntity<>("product created", HttpStatus.OK);
    }

    @GetMapping("api/get/allProduct")
    public ResponseEntity<Set<ProductType>> getAllProductsType() {
        Set<ProductType> all = productTypeService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("api/get/product/byID")
    public ResponseEntity<ProductType> findProductByID(@RequestParam Long productID) {

        Optional<ProductType> byId = productTypeService.findById(productID);

        if (byId.isPresent()){
            return new ResponseEntity<>(byId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("api/get/product/ByName")
    public ResponseEntity<List<ProductType>> findProductTypesByName(@RequestParam String search) {
        List<ProductType> all = productTypeService.findProductTypesByName(search);

        return new ResponseEntity<>(all, HttpStatus.OK);
    }





}
