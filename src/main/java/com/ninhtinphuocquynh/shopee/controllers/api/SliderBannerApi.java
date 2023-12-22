package com.ninhtinphuocquynh.shopee.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SliderBannerApi {
    @Qualifier("sliderBannerServiceImpl")
    @Autowired
    private SliderBannerService service;

    @GetMapping("/api/v1/slider-banner/all")
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<SliderBanner> sliderBanners = service.findAll();

        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("cache", sliderBanners.size());
        customResponse.put("products", sliderBanners);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(customResponse);

        return ResponseEntity.ok(jsonResponse);
    }
}
