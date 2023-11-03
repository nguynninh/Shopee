package com.ninhtinphuocquynh.shopee.controllers.api;

import com.ninhtinphuocquynh.shopee.model.Product;
import com.ninhtinphuocquynh.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductApi {
    @Qualifier("productServiceImpl")
    @Autowired
    private ProductService service;
    @GetMapping("/api/v1/product/all")
    public List<Product> findAll() {
        return service.findAll();
    }
}
