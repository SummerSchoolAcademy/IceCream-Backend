package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.service.BasketService;
import com.summerschool.icecreamshop.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import com.summerschool.icecreamshop.dto.BasketDTO;
import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;
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

import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketControllerTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    BasketService basketService;

    @InjectMocks
    BasketController basketController;

    List<BasketProduct> basketProductList;

    BasketDTO basketDTO = new BasketDTO();

    Basket basket = new Basket();

    @Before
    public void setup(){
        initMocks(this);
        Product product1 = new Product();
        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setPrice(2.5);
        product1.setType(Type.DONUTS);

        Basket basket= new Basket();

        BasketProduct basketProduct=new BasketProduct();

        basketProduct.setProduct(product1);
        basketProduct.setBasket(basket);
        basketProduct.setPrice(product1.getPrice());
        basketProduct.setQuantity(1);

        basketProductList.add(basketProduct);

        basket.setBasketProduct(basketProductList);



        basket.setId(5L);
        basket.setSessionId("ceva");
        basket.setBasketProduct(new ArrayList<BasketProduct>());

        basketDTO.setId(5L);
        basketDTO.setSessionId("ceva");
    }

    @Test
    public void testGetAllProducts() {
        Mockito.when(basketService.getProductsFromBasket())
                .thenReturn(basketProductList);

        ResponseEntity<List<BasketProduct>> response = basketController.getBasketProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
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
