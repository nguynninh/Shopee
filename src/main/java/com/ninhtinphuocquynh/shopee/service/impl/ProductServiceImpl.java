package com.ninhtinphuocquynh.shopee.service.impl;

import com.ninhtinphuocquynh.shopee.model.Product;
import com.ninhtinphuocquynh.shopee.repository.ProductRepository;
import com.ninhtinphuocquynh.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
