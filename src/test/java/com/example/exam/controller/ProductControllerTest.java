package com.example.exam.controller;

import com.example.exam.model.ProductType;
import com.example.exam.service.ProductService;
import com.example.exam.service.ProductTypeService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
class ProductControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductService productService;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productTypeService, productService)).build();
    }


    @Test
    void createProductType() throws Exception {
        mockMvc.perform(post("/api/post/create/productTypes").contentType(APPLICATION_JSON)
                        .content(

                                """
                                {
                                    "name": "nød",
                                    "price": 10,
                                    "weightGram": 1000
                                }
                                """


                        ).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getAllProductsType() throws Exception {
        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);

        mockMvc.perform(get("/api/get/allProduct").contentType(APPLICATION_JSON)
                        .content("").characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    void deleteProductTypeByID() throws Exception {

        ProductType productType = new ProductType();
        productType.setName("asd");
        ProductType productType2 = new ProductType();
        productType.setName("asd2");
        ProductType productType3 = new ProductType();
        productType.setName("asd3");

        ProductType save = productTypeService.save(productType);
        productTypeService.save(productType2);
        productTypeService.save(productType3);


        mockMvc.perform(delete("/api/delete/productType/ByID?productTypeID=" + save.getId()).contentType(APPLICATION_JSON)
                        .content("").characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}