package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findById(int id);

    @Query(nativeQuery = true, value =
            "Select * From products Join (Select * From basket_products Where basket_products.basket_id = :basketId) as basket_products On products.id=basket_products.product_id")
    List<Product> queryGetBasketProducts(Long basketId);
}