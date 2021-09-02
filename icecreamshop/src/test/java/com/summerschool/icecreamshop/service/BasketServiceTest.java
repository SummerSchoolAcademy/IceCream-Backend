package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketServiceTest {

    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private CategoryService categoryService;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void testUpdateBasket() {

        Basket basket = new Basket();
        basket.setId(1L);
        basket.setSessionId("session");

        when(basketRepository.save(basket)).thenReturn(basket);
        Basket responseBasket = basketService.update(basket,new ArrayList<BasketProduct>());
        assertNotNull(responseBasket);
    }
}