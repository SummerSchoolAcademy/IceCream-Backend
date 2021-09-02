package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;


    Page<Product> productsPage;

    Product product1 = new Product();

    List<Product> productsList;

    @Before
    public void setup(){
        initMocks(this);

        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setType(Type.DONUTS);
        product1.setPrice(2.5);
    }

    @Test
    public void testServiceForGetAllProducts(){
        productsList= new ArrayList<Product>();
        productsList.add(product1);

        Mockito.when(productRepository.findAll())
                .thenReturn(productsList);

        List<Product> response = productService.getAll();

        assertNotNull(response);
    }

    @Test
    public void testServiceForGetProductsWithPagination(){

        productsPage= new PageImpl<>(Arrays.asList(product1));

        Mockito.when(productRepository.findAll(any(Pageable.class)))
                .thenReturn(productsPage);

        List<Product> response = productService.getProductsOfThePage(0,5);

        assertNotNull(response);
        assertEquals(1,response.size());
    }
}