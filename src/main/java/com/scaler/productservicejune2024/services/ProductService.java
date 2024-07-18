package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.CustomException.ProductNotFoundException;
import com.scaler.productservicejune2024.dtos.FakeStoreProductdto;
import com.scaler.productservicejune2024.models.Product;
import java.util.List;
public interface ProductService {
    Product getSingleProduct(Long ProductId) throws ProductNotFoundException;

       List<Product> getAllProducts();

       Product updateProduct(Long id,Product product) throws ProductNotFoundException;
       Product replaceProduct(Long id,Product product);
        void deleteProduct(Long id);
        Product addNewProduct(Product product);



}
