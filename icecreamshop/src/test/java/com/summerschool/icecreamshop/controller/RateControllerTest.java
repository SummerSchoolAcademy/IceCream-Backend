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

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
public class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Mock
    private ModelMapper modelMapper;


    private RateDTO rateDTO=new RateDTO();
    private Rate rate=new Rate();

    @Before
    public void setUp(){
        initMocks(this);

        rate.setId(1L);
       // rate.setRate(5);

        rateDTO.setId(1L);
        //rateDTO.setRate(4);
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


}
