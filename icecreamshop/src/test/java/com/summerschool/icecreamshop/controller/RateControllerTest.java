package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.dto.RateDTO;
import com.summerschool.icecreamshop.service.RateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.MockitoAnnotations.openMocks;
import static com.summerschool.icecreamshop.exception.Constants.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Mock
    private ModelMapper modelMapper;


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
    public void testCreateRate() {

        Mockito.when(modelMapper.map(rateDTO, Rate.class)).thenReturn(rate);
        Mockito.when(rateService.add(rate)).thenReturn(rate);
        ResponseEntity<RateDTO> responseEntity = rateController.add(rateDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

    }

    @Test
    public void testCreateRate_failedToCreate(){

        Mockito.when(modelMapper.map(rateDTO, Rate.class)).thenReturn(rate);
        Mockito.when(rateService.add(rate)).thenReturn(null);
        ResponseEntity<RateDTO> responseEntity = rateController.add(rateDTO);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateProductRating() {

        Mockito.when(modelMapper.map(rateDTO,Rate.class)).thenReturn(rate);
        Mockito.when(rateService.get(ArgumentMatchers.any())).thenReturn(Optional.of(rate));
        Mockito.when(rateService.update(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(rate);
        ResponseEntity<RateDTO> responseEntity = rateController.update(rate.getId(),rateDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity);

    }

    @Test
    public void testGetProductRatingOk(){
        Mockito.when(modelMapper.map(rateDTO,Rate.class)).thenReturn(rate);
        Mockito.when(rateService.get(rate.getRate().longValue())).thenReturn(Optional.of(rate));
        ResponseEntity<List<RateDTO>> responseEntity = rateController.get(rate.getRate().longValue());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetProductRatingNotFound(){
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            rateController.get(-1L);
        });

        assertTrue(exception.getMessage().contains(PRODUCT_NOT_FOUND));
    }

}
