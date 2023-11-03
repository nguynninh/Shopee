package com.ninhtinphuocquynh.shopee.service.impl;

import com.ninhtinphuocquynh.shopee.dto.SliderBannerDTO;
import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import com.ninhtinphuocquynh.shopee.repository.SliderBannerRepository;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SliderBannerServiceImpl implements SliderBannerService {
    @Autowired
    private SliderBannerRepository repository;

    @Override
    public List<SliderBanner> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SliderBannerDTO> findAllByTrue() {
        List<SliderBanner> sliderBanners = repository.findAll();
        List<SliderBannerDTO> sliderBannersIsTrue = new ArrayList<>();

        for (SliderBanner s : sliderBanners) {
            if (s.isEmpty())
                sliderBannersIsTrue.add(
                        new SliderBannerDTO(
                                s.getId(),
                                s.getName(),
                                s.getImage()
                        )
                );
        }
        return sliderBannersIsTrue;
    }
}
