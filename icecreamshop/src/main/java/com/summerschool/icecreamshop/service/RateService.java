package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateService {

    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate add(Rate rate) {
        return rateRepository.save(rate);
    }
}
