package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findById(int id);

    @Query(nativeQuery = true, value = "Select * From products Where products.how_many_alergens=0")
    List<Product> querySpecialProducts();
}