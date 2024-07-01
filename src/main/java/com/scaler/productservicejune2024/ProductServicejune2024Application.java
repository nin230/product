package com.scaler.productservicejune2024;

import com.scaler.productservicejune2024.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServicejune2024Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServicejune2024Application.class, args);

        Product product = new Product();
    }

}
