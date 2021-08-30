package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.RateDTO;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.service.RateService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RateDTO rateDTO;

    @Before
    public void setUp(){
        Rate rate = new Rate();
        rate.setId(1L);
        rate.setRate(5);

        RateDTO rateDTO = new RateDTO();
        rateDTO.setId(1L);
        rateDTO.setRate(4);
    }

    @Test
    public void testUpdateProductRating(Long id) {

        Mockito.when(rateService.update(rate,new Product())).thenReturn(rate);
        ResponseEntity<RateDTO> r = rateController.update(rate.getId(),rateDTO);
        assertEquals(HttpStatus.OK, r.getStatusCode());
        assertNotNull(r);

    }
}
