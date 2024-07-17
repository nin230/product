package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.CustomException.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.repositories.ProductRepositiory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService  implements ProductService{
    private ProductRepositiory productRepositiory;


    public SelfProductService(ProductRepositiory productRepositiory){

        this.productRepositiory= productRepositiory;
    }



    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException{

        Optional<Product> productOptional= productRepositiory.findById(ProductId);
         if(productOptional.isEmpty()){
             throw new ProductNotFoundException("product with id"+ ProductId+"doesn't exist");
         }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }
}
