package com.scaler.productservicejune2024.services;


import com.scaler.productservicejune2024.CustomException.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.repositories.CategoryRepository;
import com.scaler.productservicejune2024.repositories.ProductRepositiory;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService  implements ProductService{
    private ProductRepositiory productRepositiory;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepositiory productRepositiory, CategoryRepository categoryRepository){

        this.productRepositiory= productRepositiory;
        this.categoryRepository=categoryRepository;
    }



    @Override
    public Product getSingleProduct(Long ProductId)
            throws ProductNotFoundException
    {

        Optional<Product> productOptional= productRepositiory.findById(ProductId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("product with id"+ ProductId+"doesn't exist");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositiory.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct= productRepositiory.findById(id);

        if(optionalProduct.isEmpty()){
            throw  new ProductNotFoundException("Product with  id" + id + "not found");
        }
         Product productInDB = optionalProduct.get();
        if(product.getTitle() != null){
         productInDB.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            productInDB.setPrice(product.getPrice());
        }
        return productRepositiory.save(productInDB);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepositiory.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId()==null){
         category = categoryRepository.save(category);
         product.setCategory(category);
        }
        return productRepositiory.save(product);

    }
}
