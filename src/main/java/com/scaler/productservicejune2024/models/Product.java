package com.scaler.productservicejune2024.models;

import lombok.Getter;
import lombok.Setter;
 @Getter
 @Setter

public class Product extends BaseModel{
    private String Title;
    private double Price;
    private Category category;

}
