package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.dto.RateDTO;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.repository.RateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.summerschool.icecreamshop.model.Product;
import org.mockito.Mockito;
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

    private RateDTO rateDTO=new RateDTO();

    private Rate rate=new Rate();

    @Before
    public void setUp(){
        initMocks(this);

        rate.setId(1L);
        rate.setRate(5);

        rateDTO.setId(1L);
        rateDTO.setRate(4);
    }
    @Test
    public void rateAddTest() {
        Mockito.when(rateRepository.save(rate)).thenReturn(rate);
        assertEquals(rate.getRate(), rateService.add(rate).getRate());
    }
    @Test
    public void testUpdateProductRating() {

        Rate rate = new Rate();
        rate.setId(1L);
        rate.setRate(5);

        when(rateRepository.save(rate)).thenReturn(rate);
        Rate responseRate = rateService.update(rate,new Product());
        assertNotNull(responseRate);
        assertEquals(Integer.valueOf(5),responseRate.getRate());
    }

}
