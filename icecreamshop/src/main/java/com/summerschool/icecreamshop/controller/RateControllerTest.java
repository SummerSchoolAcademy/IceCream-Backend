package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.RateDTO;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.service.RateService;
import io.swagger.models.Model;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;


public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Mock
    private ModelMapper modelMapper;


    private RateDTO rateDTO;
    private Rate rate;

    @Before
    public void setUp(){
        initMocks(this);

        rate.setId(1L);
        rate.setRate(5);

        rateDTO.setId(1L);
        rateDTO.setRate(4);
    }

    @Test
    public void testUpdateProductRating() {

        Mockito.when(modelMapper.map(rateDTO,Rate.class)).thenReturn(rate);
        Mockito.when(rateService.update(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(rate);
        ResponseEntity<RateDTO> r = rateController.update(rate.getId(),rateDTO);
        assertEquals(HttpStatus.OK, r.getStatusCode());
        assertNotNull(r);

    }


}
