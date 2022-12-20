package com.example.exam.controller;


import com.example.exam.model.Product;
import com.example.exam.model.ProductType;
import com.example.exam.model.ProductTypeWithProducts;
import com.example.exam.repository.ProductRepository;
import com.example.exam.response.DeleteResponse;
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
public class ProductController {
    private ProductTypeService productTypeService;
    private ProductService productService;

    @PostMapping("api/post/create/productTypes")
    public ResponseEntity<ProductType> createProductType(@RequestBody ProductType productType) {
        ProductType save = productTypeService.save(productType);

        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("api/get/allProduct")
    public ResponseEntity<Set<ProductType>> getAllProductsType() {
        Set<ProductType> all = productTypeService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("api/get/product/byID")
    public ResponseEntity<ProductTypeWithProducts> findProductByID(@RequestParam Long productID) {
        Optional<ProductType> byId = productTypeService.findById(productID);

        ProductType productType = byId.orElse(null);


        if (byId.isPresent()){
            List<Product> withProductTypeIDWithNoDelivery = productService.getWithProductTypeIDWithNoDelivery(productType);


            productType.setProducts(new HashSet<>(withProductTypeIDWithNoDelivery));


            ProductTypeWithProducts productTypeWithProducts = new ProductTypeWithProducts(withProductTypeIDWithNoDelivery);
            productTypeWithProducts.setName(productType.getName());
            productTypeWithProducts.setWeightGram(productType.getWeightGram());
            productTypeWithProducts.setId(productType.getId());
            productTypeWithProducts.setPrice(productType.getPrice());


            return new ResponseEntity<>(productTypeWithProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("api/get/product/ByName")
    public ResponseEntity<List<ProductType>> findProductTypesByName(@RequestParam String search) {
        List<ProductType> all = productTypeService.findProductTypesByName(search);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("api/delete/productType/ByID")
    public ResponseEntity<DeleteResponse> deleteProductTypeByID(@RequestParam Long productTypeID){

        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("product: " + productTypeID +  " Deleted");
        deleteResponse.setIdOfDeleted("productTypeID");

        productTypeService.deleteById(productTypeID);



        return new ResponseEntity<>(deleteResponse , HttpStatus.OK);
    }

    @PostMapping("api/post/add/productStock")
    public ResponseEntity<ProductType> addProductStock(@RequestParam Long productID, @RequestParam int amount) {

        Optional<ProductType> byId = productTypeService.findById(productID);
        productService.addStock(byId.orElse(null), amount);


        return new ResponseEntity<ProductType>(byId.orElse(null), HttpStatus.OK);
    }


    @GetMapping("api/get/productInStock/ByName")
    public ResponseEntity<List<ProductTypeWithProducts>> findProductTypesByNameWithProduct(@RequestParam String search){
        List<ProductTypeWithProducts> withProduct = new ArrayList();

        List<ProductType> all = productTypeService.SearchNameProductTypeWithProducts(search);

        ListIterator<ProductType> productTypeListIterator = all.listIterator();

        while (productTypeListIterator.hasNext()){
            ProductType productType = productTypeListIterator.next();

            List<Product> withProductTypeIDWithNoDelivery = productService.getWithProductTypeIDWithNoDelivery(productType);


            ProductTypeWithProducts productTypeWithProducts = new ProductTypeWithProducts(withProductTypeIDWithNoDelivery);
            productTypeWithProducts.setName(productType.getName());
            productTypeWithProducts.setWeightGram(productType.getWeightGram());
            productTypeWithProducts.setId(productType.getId());
            productTypeWithProducts.setPrice(productType.getPrice());


            withProduct.add(productTypeWithProducts);
        }


        return new ResponseEntity<>(withProduct, HttpStatus.OK);
    }







}
