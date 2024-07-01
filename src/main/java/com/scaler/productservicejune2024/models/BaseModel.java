package com.scaler.productservicejune2024.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
