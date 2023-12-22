package com.ninhtinphuocquynh.shopee.repository;

import com.ninhtinphuocquynh.shopee.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Override
    List<Category> findAll();

    Category findByName(String name);
}
