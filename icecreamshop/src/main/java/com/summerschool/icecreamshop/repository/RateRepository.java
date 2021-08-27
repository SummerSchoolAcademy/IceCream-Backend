package com.summerschool.icecreamshop.repository;

import com.summerschool.icecreamshop.model.Product;

import com.summerschool.icecreamshop.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

}