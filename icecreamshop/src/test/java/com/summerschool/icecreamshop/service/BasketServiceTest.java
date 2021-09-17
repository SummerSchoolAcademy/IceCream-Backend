package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Basket;
import com.summerschool.icecreamshop.model.BasketProduct;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.repository.BasketProductRepository;

import com.summerschool.icecreamshop.repository.BasketRepository;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
public class BasketServiceTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private CategoryService categoryService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    BasketProductRepository basketProductRepository;

    @InjectMocks
    BasketService basketService;

    List<Product> productListAvra;

    List<BasketProduct> basketProductListAvra;

    Product product1 = new Product();

    BasketProduct basketProduct=new BasketProduct();

    Basket basketAvra= new Basket();

    Basket basket = new Basket();

    Basket basket1 = new Basket();

    Basket basket2 = new Basket();

    @Before
    public void setup(){
        initMocks(this);

        productListAvra = new ArrayList<Product>();
        basketProductListAvra = new ArrayList<BasketProduct>();

        product1.setId(1L);
        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setPrice(2.5);
        product1.setType(Type.DONUTS);

        basketProduct.setProduct(product1);
        basketProduct.setBasket(basketAvra);
        basketProduct.setQuantity(1);
        basketProduct.setId(1L);

        productListAvra.add(product1);
        basketProductListAvra.add(basketProduct);

        basketAvra.setBasketProduct(basketProductListAvra);
        basketAvra.setId(2L);
        basketAvra.setSessionId("String");


        basket.setId(5L);
        basket.setSessionId("ceva");
        basket.setBasketProduct(new ArrayList<BasketProduct>());

        basket1.setId(11L);
        basket1.setSessionId("test1");

        basket2.setId(12L);
        basket2.setSessionId("test2");
        List<BasketProduct> basketProductList = new ArrayList<BasketProduct>();
        basketProductList.add(new BasketProduct());
        basket2.setBasketProduct(basketProductList);

    }

    @Test
    public void testGetAllProducts(){
        Mockito.when(basketProductRepository.queryGetBasketProducts(basket.getId()))
                .thenReturn(basketProductListAvra);

        List<BasketProduct> productListReturned = basketService.getProductsFromBasket(basket.getId());

        assertEquals(basketProductListAvra, productListReturned);
    }

    @Test
    public void testUpdateBasket() {
        Mockito.when(basketService.patch(basket2, basket1)).thenReturn(basket1);
        Mockito.when(basketRepository.save(basket1)).thenReturn(basket2);
        assertEquals(basketRepository.save(basket1).getBasketProduct(), basket2.getBasketProduct());
    }

    @Test
    public void basketAddTest() {

        Mockito.when(basketRepository.save(basket1)).thenReturn(basket1);
        Mockito.when(basketService.add(basket1)).thenReturn(basket1);
        assertEquals(basket1.getSessionId(), basketService.add(basket1).getSessionId());
    }
}
