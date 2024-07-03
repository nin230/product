package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.dtos.FakeStoreProductdto;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public  class FakeStoreProductService implements ProductService
{
private RestTemplate restTemplate;

     public FakeStoreProductService(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
     }
    @Override
    public Product getSingleProduct(Long ProductId) {

         throw new ArithmeticException();
         //throw new RuntimeException("Something went wrong");
        //call Fakestore  to fetch product with given id ==>HTTP call
//        FakeStoreProductdto fakeStoreProductdto= restTemplate.getForObject
//                ("https://fakestoreapi.com/products/" + ProductId,
//                        FakeStoreProductdto.class);
        //return convertFakeProductDtoToProduct(fakeStoreProductdto);
    }
    //Convert fakestore dto into Product(data tranfer object)


    @Override
    public List<Product> getAllProducts() {
       FakeStoreProductdto[] fakeStoreProductdtos= restTemplate.getForObject("https://fakestoreapi.com/products"
        ,FakeStoreProductdto[].class);

       //convert list of FakeStore Dto into list of product
       List<Product> products = new ArrayList<>();
       for(FakeStoreProductdto fakeStoreProductdto: fakeStoreProductdtos){
           products.add(convertFakeProductDtoToProduct(fakeStoreProductdto));
       }

       return products;
     }
     //Partial update
    @Override
    public Product updateProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductdto.class);
        HttpMessageConverterExtractor<FakeStoreProductdto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductdto.class,
                restTemplate.getMessageConverters());
         FakeStoreProductdto response =restTemplate.execute("https://fakestoreapi.com/products" + id,
                HttpMethod.PATCH, requestCallback, responseExtractor);
        return convertFakeProductDtoToProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }


    private Product convertFakeProductDtoToProduct(FakeStoreProductdto fakeStoreProductdto) {
         Product product = new Product();
         product.setId(fakeStoreProductdto.getId());
         product.setTitle(fakeStoreProductdto.getTitles());
         product.setPrice(fakeStoreProductdto.getPrice());

         Category category = new Category();
         category.setDescription(fakeStoreProductdto.getCategory());
         product.setCategory(category);

         return product;
     }
}
