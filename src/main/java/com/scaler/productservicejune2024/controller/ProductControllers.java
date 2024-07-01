package com.scaler.productservicejune2024.controller;

import com.scaler.productservicejune2024.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductControllers {

         //http://localhost:8080/products/10
         @GetMapping("/{id}")
        public Product getProductById(@PathVariable("id") Long id){
             return null;
        }

        public ArrayList<Product> getAllProducts(){
            return new ArrayList<>();
        }
}
