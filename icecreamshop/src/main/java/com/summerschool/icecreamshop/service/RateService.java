
package com.summerschool.icecreamshop.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.ISBNValidator;
import com.summerschool.icecreamshop.exception.InvalidISBNException;

import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Product;
import java.util.Optional;

import javax.swing.text.html.Option;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private ProductService productService;

    public Optional<Rate> get(Long id){

        return rateRepository.findById(id);
    }

    public Rate update(Rate rate, Product product) throws InvalidISBNException {


        rate.setProduct(product);

        return rateRepository.save(rate);

    }
}

