package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.BasketDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.service.BasketService;
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
public class BasketControllerTest {

    @InjectMocks
    private BasketController basketController;

    @Mock
    private BasketService basketService;

    @Mock
    private ModelMapper modelMapper;

    private BasketDTO basketDTO = new BasketDTO();
    private Basket basket = new Basket();

    @Before
    public void setUp(){
        initMocks(this);

        basket.setId(1L);
        basket.setSessionId("session");

        basketDTO.setId(1L);
        basket.setSessionId("session2");

    }

    @Test
    public void testUpdateBasket(){
        Mockito.when(modelMapper.map(basketDTO, Basket.class)).thenReturn(basket);
        Mockito.when(basketService.get(ArgumentMatchers.any())).thenReturn(Optional.of(basket));
        Mockito.when(basketService.patch(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(basket);
        ResponseEntity<BasketDTO> r = basketController.update(basket.getId(),basketDTO);
        assertEquals(HttpStatus.OK, r.getStatusCode());
        assertNotNull(r);
    }

}
