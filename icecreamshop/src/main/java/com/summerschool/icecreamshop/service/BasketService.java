package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Basket add(Basket basket) {

        try
        {
            return basketRepository.save(basket);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
