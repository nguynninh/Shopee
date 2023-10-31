package com.ninhtinphuocquynh.shopee.repository;

import com.ninhtinphuocquynh.shopee.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
}
