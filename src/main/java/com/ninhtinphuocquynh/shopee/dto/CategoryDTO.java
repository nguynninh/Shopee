package com.ninhtinphuocquynh.shopee.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int id;
    private String image;
    private String name;
    private String link;

    private boolean isEmpty;
}
