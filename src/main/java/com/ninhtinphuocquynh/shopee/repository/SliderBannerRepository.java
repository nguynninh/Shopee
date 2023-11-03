package com.ninhtinphuocquynh.shopee.repository;

import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderBannerRepository extends JpaRepository<SliderBanner, Integer> {
    @Override
    List<SliderBanner> findAll();
}
