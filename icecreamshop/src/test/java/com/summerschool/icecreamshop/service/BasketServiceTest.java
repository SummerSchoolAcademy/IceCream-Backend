package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.repository.BasketRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.*;

import static org.junit.Assert.assertEquals;
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
        Basket basket1 = new Basket();
        basket1.setId(11L);
        basket1.setSessionId("test1");

        Basket basket2 = new Basket();
        basket2.setId(12L);
        basket2.setSessionId("test2");
        List<BasketProduct> basketProductList = new ArrayList<BasketProduct>();
        basketProductList.add(new BasketProduct());
        basket2.setBasketProduct(basketProductList);

        when(basketRepository.save(basket1)).thenReturn(basket1);
        Basket responseBasket = basketService.patch(basket2,basket1);
        assertNotNull(responseBasket);
        assertEquals(basket1.getBasketProduct(),basketProductList);
    }
}