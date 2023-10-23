package com.ninhtinphuocquynh.shopee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SliderBannerDTO {
    private int id;
    private String name;
    private String image;
    private boolean isEmpty;
}
