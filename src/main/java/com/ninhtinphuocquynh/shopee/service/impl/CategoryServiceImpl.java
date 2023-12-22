package com.ninhtinphuocquynh.shopee.service.impl;

import com.ninhtinphuocquynh.shopee.model.Category;
import com.ninhtinphuocquynh.shopee.repository.CategoryRepository;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public @ResponseBody List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(Category category) {
        if (repository.findByName(category.getName()) == null) {
            repository.save(category);
            return true;
        } else return false;
    }
}
