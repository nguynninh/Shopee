package com.ninhtinphuocquynh.shopee.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHomeDTO {
    private int id;
    private String image;
    private String name;
    private String price;
    private String selled;
    private String imageOptions;
    private String discountPercentTop;
    private String discountPercentBottom;

}
