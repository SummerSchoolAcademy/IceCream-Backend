package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByProductId(Long productId);

//    @Query(nativeQuery = true, value = "Select * From rates Where rates.product_id = :productId")
//    List<Rate> queryGetRates(Long productId);

}