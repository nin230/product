package com.scaler.productservicejune2024.repositories;

import com.scaler.productservicejune2024.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
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
}

/*
1.Repositiory should be an interface.
2. Repositiory should extend JPArepositiory
 */