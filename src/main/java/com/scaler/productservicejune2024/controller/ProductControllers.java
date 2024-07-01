package com.scaler.productservicejune2024.controller;

import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.services.FakeStoreProductService;
import com.scaler.productservicejune2024.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllers {
     private ProductService productService;

        public ProductControllers(ProductService productService) {
            this.productService = productService;
        }


         //http://localhost:8080/products/10
         @GetMapping("/{id}")
        public Product getProductById(@PathVariable("id") Long id){
             return productService.getSingleProduct(id);
        }
         @GetMapping()
        public List<Product> getAllProducts(){
            return  productService.getAllProducts();
        }
}
