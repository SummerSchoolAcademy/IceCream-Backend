package com.summerschool.icecreamshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Product;
import java.util.Optional;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    public Optional<Rate> get(Long id){

        return rateRepository.findById(id);
    }

    public Rate update(Rate rate, Product product){


        rate.setProduct(product);

        return rateRepository.save(rate);

    }
}

