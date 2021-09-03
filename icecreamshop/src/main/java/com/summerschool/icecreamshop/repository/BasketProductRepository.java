package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
    @Query(nativeQuery = true, value = "Select * From basket_products Where basket_id  = :basketId)")
    List<BasketProduct> queryGetProductsInBasketById(Long basketId);
}
