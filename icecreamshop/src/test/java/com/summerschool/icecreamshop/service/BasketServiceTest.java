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
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketServiceTest {

    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private CategoryService categoryService;

    Basket basket1 = new Basket();

    Basket basket2 = new Basket();

    @Before
    public void setUp(){

        basket1.setId(11L);
        basket1.setSessionId("test1");


        basket2.setId(12L);
        basket2.setSessionId("test2");
        List<BasketProduct> basketProductList = new ArrayList<BasketProduct>();
        basketProductList.add(new BasketProduct());
        basket2.setBasketProduct(basketProductList);
    }


    @Test
    public void testUpdateBasket() {
        Mockito.when(basketService.patch(basket2, basket1)).thenReturn(basket1);
        Mockito.when(basketRepository.save(basket1)).thenReturn(basket2);
        assertEquals(basketRepository.save(basket1).getBasketProduct(), basket2.getBasketProduct());

    @Test
    public void basketAddTest() {
        Mockito.when(basketRepository.save(basket1)).thenReturn(basket1);
        assertEquals(basket.getSessionId(), basketService.add(basket1).getSessionId());
    }
}
