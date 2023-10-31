package com.ninhtinphuocquynh.shopee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_data")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "selled")
    private int selled;

    @Column(name = "image_options")
    private String imageOptions;

    @Column(name = "discount_top")
    private int discountTop;

    @Column(name = "discount_bottom")
    private int discountBottom;

    @Column(name = "is_empty")
    private boolean isEmpty;
}
