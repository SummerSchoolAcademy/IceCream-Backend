package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Optional<Basket> get (Long id){
        return basketRepository.findById(id);
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
