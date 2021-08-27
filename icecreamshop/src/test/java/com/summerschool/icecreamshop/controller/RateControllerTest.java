package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.service.RateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Test
    public void testUpdateProductRating(Long id) {

        Rate rate = new Rate();
        rate.setId(1L);
        rate.setRate(5);

        when(rateService.update(rate,new Product())).thenReturn(rate);
        Rate responseRate = rateService.update(rate,new Product());
        assertNotNull(responseRate);
        assertEquals(5,responseRate.getRate());

        Rate rate2 = new Rate();
        rate2.setId(1L);
        rate2.setRate(null);

        when(rateService.update(rate2,new Product())).thenReturn(rate2);
        Rate responseRate2 = rateService.update(rate,new Product());
        assertNotNull(responseRate2);
        assertEquals(5,responseRate.getRate());
    }
}
