package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;

import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.repository.BasketProductRepository;

import com.summerschool.icecreamshop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private BasketProductRepository basketProductRepository;
    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketProductRepository basketProductRepository, BasketRepository basketRepository){
        this.basketRepository = basketRepository;
        this.basketProductRepository = basketProductRepository;
    }

    public List<BasketProduct> getProductsFromBasket(Long basketId){
        return basketProductRepository.findByBasketId(basketId);
    }
  
    public Optional<Basket> get (Long id){
        return basketRepository.findById(id);
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

    public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = first.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Object returnValue = clazz.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value1 = field.get(first);
            Object value2 = field.get(second);
            Object value = (value1 != null) ? value1 : value2;
            field.set(returnValue, value);
        }
        System.out.println(returnValue.toString());
        return (T) returnValue;
    }

    public Basket patch(Basket newBasket, Basket oldBasket) {
        Basket patched = null;
        try {
            patched = mergeObjects(newBasket,oldBasket);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return basketRepository.save(patched);
    }

}
