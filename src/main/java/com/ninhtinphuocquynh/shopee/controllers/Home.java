package com.ninhtinphuocquynh.shopee.controllers;

import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Home {
    @Autowired
    private SliderBannerService sliderBannerService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public ModelAndView home(Model model) {
        addSliderBanner(model);
        addCategory(model);
        return new ModelAndView("index");
    }

    public void addSliderBanner(Model model) {
        model.addAttribute("sliderbanners", sliderBannerService.findAllByTrue());
    }

    public void addCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }
}
