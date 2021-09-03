package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.BasketDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.service.BasketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketControllerTest {

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    BasketController basketController;

    @Mock
    BasketService basketService;

    BasketDTO basketDTO = new BasketDTO();

    Basket basket = new Basket();

    @Before
    public void setUp() {
        initMocks(this);
        basket.setId(5L);
        basket.setSessionId("ceva");
        basket.setBasketProduct(new ArrayList<BasketProduct>());

        basketDTO.setId(5L);
        basketDTO.setSessionId("ceva");
    }

    @Test
    public void testCreateBasket() {

        Mockito.when(modelMapper.map(basketDTO, Basket.class)).thenReturn(basket);
        Mockito.when(basketService.add(basket)).thenReturn(basket);

        ResponseEntity<BasketDTO> basketDTOResponseEntity = basketController.add(basketDTO);

        assertEquals(HttpStatus.CREATED, basketDTOResponseEntity.getStatusCode());
    }

    @Test
    public void testCreateBasket_failedToCreate(){

        Mockito.when(modelMapper.map(basketDTO, Basket.class)).thenReturn(basket);
        Mockito.when(basketService.add(basket)).thenReturn(null);
        ResponseEntity<BasketDTO> responseEntity = basketController.add(basketDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
