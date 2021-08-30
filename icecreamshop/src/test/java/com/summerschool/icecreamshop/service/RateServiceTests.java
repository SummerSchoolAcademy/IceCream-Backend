package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.repository.RateRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Optional;
import org.mockito.junit.MockitoJUnitRunner;
import com.summerschool.icecreamshop.model.Product;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(SpringJUnit4ClassRunner.class)
public class RateServiceTests {

    @InjectMocks
    private RateService rateService;

    @Mock
    private RateRepository rateRepository;

    @Before
    public void setup(){
        initMocks(this);
    }

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
