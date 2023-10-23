package com.ninhtinphuocquynh.shopee.service;

import com.ninhtinphuocquynh.shopee.dto.SliderBannerDTO;
import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SliderBannerService {
    List<SliderBanner> findAll();
    List<SliderBannerDTO> findAllByTrue();
}
