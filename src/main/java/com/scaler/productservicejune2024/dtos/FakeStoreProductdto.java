package com.scaler.productservicejune2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductdto {
    private Long id;
    private String titles;
    private double price;
    private String category;
    private String description;
    private String image;
}