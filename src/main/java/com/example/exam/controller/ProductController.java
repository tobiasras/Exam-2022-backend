package com.example.exam.controller;


import com.example.exam.model.ProductType;
import com.example.exam.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
public class ProductController {

    private ProductTypeService productTypeService;

    @PostMapping("api/post/create/productType")
    public ResponseEntity<String> createProductType(@RequestBody ProductType productType){
        productTypeService.save(productType);


        return new ResponseEntity<>("product created", HttpStatus.OK);
    }






}
