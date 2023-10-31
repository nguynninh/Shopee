package com.ninhtinphuocquynh.shopee.controllers;

import com.ninhtinphuocquynh.shopee.dto.ProductHomeDTO;
import com.ninhtinphuocquynh.shopee.model.Product;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import com.ninhtinphuocquynh.shopee.service.ProductService;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeControllers {
    @Autowired
    private SliderBannerService sliderBannerService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView home(Model model) {
        addSliderBanner(model);
        addCategory(model);
        addProducts(model);
        return new ModelAndView("index");
    }

    public void addSliderBanner(Model model) {
        model.addAttribute("sliderbanners", sliderBannerService.findAllByTrue());
    }

    public void addCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }

    private void addProducts(Model model) {
        final String folder = "https://nguyenninh-my.sharepoint.com/personal/admin_nguyenninh_onmicrosoft_com/Documents/shopee/image/products/";

        List<Product> products = productService.findAll();
        List<ProductHomeDTO> productList = new ArrayList<>();

        for (int i = 0; i < Math.min(products.size(), 36); i++) {
            Product product = products.get(i);
            if (product.isEmpty())
                productList.add(new ProductHomeDTO(
                        product.getId(),
                        folder + product.getImage(),
                        product.getName(),
                        convertPrice(product.getPrice()),
                        convertSeller(product.getSelled()),
                        folder + product.getImageOptions(),
                        product.getDiscountTop() + "%",
                        "Giảm " + product.getDiscountBottom() + "%"
                ));
        }
        model.addAttribute("products", productList);
    }

    private String convertPrice(double price) {
        long roundedPrice = Math.round(price);
        java.text.DecimalFormat df = new java.text.DecimalFormat("###,###đ");
        return df.format(roundedPrice).replace(",", ".");
    }


    private String convertSeller(int sold) {
        if (sold < 1000) {
            return "Đã bán " + sold;
        } else if (sold < 1000000) {
            double kValue = sold / 1000.0;
            return String.format("Đã bán %.1fK", kValue);
        } else {
            double mValue = sold / 1000000.0;
            return String.format("Đã bán %.1fM", mValue);
        }
    }
}
