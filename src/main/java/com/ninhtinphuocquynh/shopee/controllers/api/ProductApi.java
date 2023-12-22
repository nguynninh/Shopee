package com.ninhtinphuocquynh.shopee.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhtinphuocquynh.shopee.model.Product;
import com.ninhtinphuocquynh.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductApi {
    @Qualifier("productServiceImpl")
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<Product> products = service.findAll();

        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("cache", products.size());
        customResponse.put("products", products);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(customResponse);

        return ResponseEntity.ok(jsonResponse);
    }

    @GetMapping("/entity")
    public ResponseEntity<Product> findEntity(@RequestParam int id) {
        List<Product> products = service.findAll();
        if (id >= 0 && id < products.size()) {
            return ResponseEntity.ok(products.get(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
