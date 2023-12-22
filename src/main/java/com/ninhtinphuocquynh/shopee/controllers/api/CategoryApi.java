package com.ninhtinphuocquynh.shopee.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhtinphuocquynh.shopee.model.Category;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {
    @Qualifier("categoryServiceImpl")
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<Category> categories = service.findAll();

        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("cache", categories.size());
        customResponse.put("category", categories);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(customResponse);

        return ResponseEntity.ok(jsonResponse);
    }

    @PostMapping("/entity")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        if(service.add(category)){
            return ResponseEntity.ok("Thanh cong");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
