package com.ninhtinphuocquynh.shopee.repository;

import com.ninhtinphuocquynh.shopee.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Override
    List<Category> findAll();
}
