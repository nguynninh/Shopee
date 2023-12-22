package com.ninhtinphuocquynh.shopee.service;

import com.ninhtinphuocquynh.shopee.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
    boolean add(Category category);
}
