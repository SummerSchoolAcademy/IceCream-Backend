package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByProductId(Long productId);
}