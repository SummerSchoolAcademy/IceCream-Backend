package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Optional<Basket> get (Long id){
        return basketRepository.findById(id);
    }

    public Basket update (Basket basket , List<BasketProduct> basketProductList){

        basket.setBasketProduct(basketProductList);
        return basketRepository.save(basket);
    }

}
