package com.summerschool.icecreamshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Product;
import java.util.Optional;

@Service
public class RateService {

    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate add(Rate rate) {
        try
        {
            return rateRepository.save(rate);
        }
        catch(Exception e){
            return null;
        }


    }

    public Optional<Rate> get(Long id){

        return rateRepository.findById(id);
    }

    public Rate update(Rate rate, Product product){


        rate.setProduct(product);

        return rateRepository.save(rate);

    }
}

