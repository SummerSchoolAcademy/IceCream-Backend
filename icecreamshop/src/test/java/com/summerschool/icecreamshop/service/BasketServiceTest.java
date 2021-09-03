package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketServiceTest {

    @InjectMocks
    BasketService basketService;

    @Mock
    BasketRepository basketRepository;

    Basket basket = new Basket();

    @Before
    public void setUp() {
        basket.setId(5L);
        basket.setSessionId("ceva");
        basket.setBasketProduct(new ArrayList<BasketProduct>());
    }

    @Test
    public void basketAddTest() {
        Mockito.when(basketRepository.save(basket)).thenReturn(basket);
        assertEquals(basket.getSessionId(), basketService.add(basket).getSessionId());
    }
}
