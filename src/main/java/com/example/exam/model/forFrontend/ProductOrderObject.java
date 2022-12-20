package com.example.exam.model.forFrontend;

import com.example.exam.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductOrderObject {

    private Long id;
    private List<ProductObject> products = new ArrayList<>();


}
