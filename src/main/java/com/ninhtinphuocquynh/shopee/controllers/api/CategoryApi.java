package com.ninhtinphuocquynh.shopee.controllers.api;

import com.ninhtinphuocquynh.shopee.model.Category;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryApi {
    @Qualifier("categoryServiceImpl")
    @Autowired
    private CategoryService service;

    @GetMapping("/api/v1/category/all")
    public List<Category> findAll() {
        return service.findAll();
    }
}
