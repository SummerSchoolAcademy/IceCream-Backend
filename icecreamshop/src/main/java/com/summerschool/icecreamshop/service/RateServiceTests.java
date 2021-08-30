package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.repository.RateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Optional;
import org.mockito.junit.MockitoJUnitRunner;
import com.summerschool.icecreamshop.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RateServiceTests {

    @InjectMocks
    private RateService rateService;

    @Mock
    private RateRepository rateRepository;

    @Test
    public void testUpdateProductRating() {

        Rate rate = new Rate();
        rate.setId(1L);
        rate.setRate(5);

        when(rateRepository.save(rate)).thenReturn(rate);
        Rate responseRate = rateService.update(rate,new Product());
        assertNotNull(responseRate);
        assertEquals(5,responseRate.getRate());
    }
}
