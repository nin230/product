package com.scaler.productservicejune2024.repositories;

import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.projections.ProductWithidAndTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositiory extends JpaRepository<Product,Long> {

   List< Product> findByPriceGreaterThan(Double price);

   List<Product> findProductByTitleLike(String word);

   List<Product> findByTitleLikeIgnoreCase(String word);

   List<Product> findTop5ByTitle(String word);
   //select * from products where title like '' Limit 5

  Optional <Product> findById(Long id);

    @Override
    List<Product> findAll(Sort sort);

    //HQL
    @Query("select p.id as id, p.Title as title from Product p where p.id = :x")
    List<ProductWithidAndTitle> randomSearchMethod(Long x);

    //SQL
    @Query(value = "select p.id as id, p.title as title from product p where p.id = :productId", nativeQuery = true)
    List<ProductWithidAndTitle> randomSearchMethod2(Long productId);

}

/*
1.Repositiory should be an interface.
2. Repositiory should extend JPArepositiory
 */