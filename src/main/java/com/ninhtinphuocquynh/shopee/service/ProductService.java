package com.ninhtinphuocquynh.shopee.service;

import com.ninhtinphuocquynh.shopee.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
}
