package com.ninhtinphuocquynh.shopee.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhtinphuocquynh.shopee.model.Category;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String findAll() throws JsonProcessingException {
        List<Category> categories = service.findAll();

        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("cache", categories.size());
        customResponse.put("category", categories);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(customResponse);

        return jsonResponse;
    }
}
