package com.scaler.productservicejune2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
 @Getter
 @Setter
 @Entity

public class Product extends BaseModel{
    private String Title;
    private Double Price;
    @ManyToOne
    private Category category;

}
