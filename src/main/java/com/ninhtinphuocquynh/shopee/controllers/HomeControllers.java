package com.ninhtinphuocquynh.shopee.controllers;

import com.ninhtinphuocquynh.shopee.dto.CategoryHomeDTO;
import com.ninhtinphuocquynh.shopee.dto.ProductHomeDTO;
import com.ninhtinphuocquynh.shopee.dto.SliderBannerDTO;
import com.ninhtinphuocquynh.shopee.model.Category;
import com.ninhtinphuocquynh.shopee.model.Product;
import com.ninhtinphuocquynh.shopee.model.SliderBanner;
import com.ninhtinphuocquynh.shopee.service.CategoryService;
import com.ninhtinphuocquynh.shopee.service.ProductService;
import com.ninhtinphuocquynh.shopee.service.SliderBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeControllers {
    @Autowired
    private SliderBannerService sliderBannerService;
    private final String folderSliderBanner = "https://nguyenninh-my.sharepoint.com/personal/admin_nguyenninh_onmicrosoft_com/Documents/shopee/image/banner/slide/";

    @Autowired
    private CategoryService categoryService;
    private final String folderCategory = "https://nguyenninh-my.sharepoint.com/personal/admin_nguyenninh_onmicrosoft_com/Documents/shopee/image/category/";

    @Autowired
    private ProductService productService;
    private final String folderProduct = "https://nguyenninh-my.sharepoint.com/personal/admin_nguyenninh_onmicrosoft_com/Documents/shopee/image/products/";

    @GetMapping("/home")
    public ModelAndView home(Model model) {
        addSliderBanner(model);
        addCategory(model);
        addProducts(model);
        return new ModelAndView("index");
    }

    public void addSliderBanner(Model model) {
        List<SliderBanner> sliderBanners = sliderBannerService.findAll();
        List<SliderBannerDTO> sliderBannerList = new ArrayList<>();

        for (int i = 0; i < sliderBanners.size(); i++) {
            SliderBanner sliderBanner = sliderBanners.get(i);
            if (sliderBanner.isEmpty())
                sliderBannerList.add(new SliderBannerDTO(
                        sliderBanner.getId(),
                        sliderBanner.getName(),
                        folderSliderBanner + sliderBanner.getImage()
                ));
        }
        model.addAttribute("sliderbanners", sliderBannerList);
    }

    public void addCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        List<CategoryHomeDTO> categoryList = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (category.isEmpty())
                categoryList.add(new CategoryHomeDTO(
                        category.getId(),
                        folderCategory + category.getImage(),
                        category.getName(),
                        category.getLink()
                ));
        }

        model.addAttribute("categories", categoryList);
    }

    private void addProducts(Model model) {
        List<Product> products = productService.findAll();
        List<ProductHomeDTO> productList = new ArrayList<>();

        for (int i = 0; i < Math.min(products.size(), 36); i++) {
            Product product = products.get(i);
            if (product.isEmpty())
                productList.add(new ProductHomeDTO(
                        product.getId(),
                        folderProduct + product.getImage(),
                        product.getName(),
                        convertPrice(product.getPrice()),
                        convertSeller(product.getSelled()),
                        convertImageOption(product.getImageOptions()),
                        product.getDiscountTop() + "%",
                        "Giảm " + product.getDiscountBottom() + "%"
                ));
        }
        model.addAttribute("products", productList);
    }

    private String convertImageOption(String image) {
        switch (image) {
            case "bg" -> {
                return folderProduct + "bg_image.png";
            }

            //Mall Shop
            case "mall" -> {
                return folderProduct + "mall.png";
            }

            //Yêu thích
            case "favorite" -> {
                return folderProduct + "yeuthich.png";
            }

            //Yêu thích +
            case "favorite_plus" -> {
                return folderProduct + "yeuthichplus.png";
            }
            default -> {
                return null;
            }
        }
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
