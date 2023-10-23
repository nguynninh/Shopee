package com.ninhtinphuocquynh.shopee.controllers.api;

import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SliderBannerApi {
    @Qualifier("sliderBannerServiceImpl")
    @Autowired
    private SliderBannerService service;

    @GetMapping("/api/v1/slider-banner/all")
    public List<SliderBanner> findAll() {
        return service.findAll();
    }
}
