package com.scaler.productservicejune2024.controller;

import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.services.FakeStoreProductService;
import com.scaler.productservicejune2024.services.ProductService;
import org.springframework.web.bind.annotation.*;


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
        public void deleteProduct(Long productid){

        }
           @PatchMapping("/{id}")
        public Product updateProduct(@PathVariable ("id")Long id, @RequestBody Product product){
            return productService.updateProduct(id,product);
        }
          @PutMapping("/{id}")
        public Product replaceProduct(@PathVariable("id") Long id,Product product){
             return null;
        }
}
