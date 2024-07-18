package com.scaler.productservicejune2024.controller;

import com.scaler.productservicejune2024.CustomException.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.services.FakeStoreProductService;
import com.scaler.productservicejune2024.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllers {
     private ProductService productService;

        public ProductControllers(@Qualifier("selfProductService") ProductService productService) {
            this.productService = productService;
        }


         //http://localhost:8080/products/10
         @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
               //throw new RuntimeException("Something went wrong");
//             ResponseEntity<Product> responseEntity= null ;
//             try {
//                 Product product = productService.getSingleProduct(id);
//                  responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
//             }
//             catch (RuntimeException e){
//                    responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//             }
              ResponseEntity<Product> response  = new ResponseEntity<>
                      (productService.getSingleProduct(id),
                      HttpStatus.OK);
             return response;
        }
         @GetMapping()
        public List<Product> getAllProducts(){
            return  productService.getAllProducts();
        }

          @DeleteMapping("/{id}")
          public void deleteAllProducts(@PathVariable("id") Long productId){
            productService.deleteProduct(productId);
          }
           @PatchMapping("/{id}")
        public Product updateProduct(@PathVariable ("id")Long id, @RequestBody Product product) throws ProductNotFoundException{
            return productService.updateProduct(id,product);
        }
          @PutMapping("/{id}")
        public Product replaceProduct(@PathVariable("id") Long id,Product product){
             return null;
        }

//        @ExceptionHandler(ArithmeticException.class)
//            public ResponseEntity<String> handleArithmeticException(){
//            ResponseEntity<String> response = new ResponseEntity<>
//                    ("ArrayIndex out of bound Exception has occured happened inside product controller" ,
//                            HttpStatus.NOT_FOUND
//
//                    );
//            return response;
//
//        }
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
                return productService.addNewProduct(product);
    }
}
