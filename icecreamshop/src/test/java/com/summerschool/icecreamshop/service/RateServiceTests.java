package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.dto.RateDTO;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.repository.RateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.summerschool.icecreamshop.model.Product;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
public class RateServiceTests {

    @InjectMocks
    private RateService rateService;


    @Mock
    private RateRepository rateRepository;

    private final RateDTO rateDTO=new RateDTO();

    private final Rate rate=new Rate();

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

    @Test
    public void testGetProductRatingOk(){
        Mockito.when(rateRepository.findById(rate.getId())).thenReturn(Optional.of(rate));
        Rate actualRate = rateService.get(1L).get();

        assertEquals(rate.getRate(), actualRate.getRate());
    }

    @Test
    public void testGetRatingFailed(){
        Rate actualRate = rateService.get(-1L).get();
        assertNotSame(rateService.get(-1L),actualRate.getRate());
    }

}
