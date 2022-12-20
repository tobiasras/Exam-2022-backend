package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.model.ProductType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@Transactional
class ProductTypeServiceTest {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;


    @Test
    void findAll() {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);

        Set<ProductType> all = productTypeService.findAll();

        assertEquals(3, all.size());

    }

    @Test
    void save() {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);

        Set<ProductType> all = productTypeService.findAll();

        assertEquals(3, all.size());
    }

    @Test
    void delete() {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        ProductType save = productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);



        productTypeService.delete(save);


        Set<ProductType> all = productTypeService.findAll();

        assertEquals(2, all.size());

    }

    @Test
    void deleteById() {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        ProductType save = productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);



        productTypeService.deleteById(save.getId());


        Set<ProductType> all = productTypeService.findAll();

        assertEquals(2, all.size());

    }

    @Test
    void findById() {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        ProductType save = productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);


        Optional<ProductType> byId = productTypeService.findById(save.getId());



        assertNotNull(byId.orElse(null));

    }
}