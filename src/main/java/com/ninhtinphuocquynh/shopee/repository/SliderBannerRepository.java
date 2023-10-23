package com.ninhtinphuocquynh.shopee.repository;

import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderBannerRepository extends CrudRepository<SliderBanner, Integer> {
    @Override
    List<SliderBanner> findAll();
}
