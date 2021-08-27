package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.RateDTO;
import com.summerschool.icecreamshop.repository.RateRepository;
import com.summerschool.icecreamshop.service.RateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RateDTO rateDTO;

    @Test
    public void testUpdateProductRating(Long id) {

        Rate rate = new Rate();
        rate.setId(1L);
        rate.setRate(5);

        Mockito.when(modelMapper.map(rateDTO,Rate.class)).thenReturn(rate);
        Mockito.when(rateService.update(rate,new Product())).thenReturn(rate);
        ResponseEntity<RateDTO> r = rateController.update(rate.getId(),rateDTO);
        assertEquals(HttpStatus.OK, r.getStatusCode());
        assertNotNull(r);

    }
}
