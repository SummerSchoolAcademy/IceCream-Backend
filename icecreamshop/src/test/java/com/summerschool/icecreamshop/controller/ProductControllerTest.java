package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductControllerTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    List<Product> productsList;

    @Before
    public void setup(){
        initMocks(this);
        Product product1 = new Product();
        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setPrice(2.5);
        product1.setType(Type.DONUTS);

        productsList= new ArrayList<Product>();
        productsList.add(product1);
    }

    @Test
    public void testGetAllProducts(){
        Mockito.when(productService.getAll())
                .thenReturn(productsList);

        ResponseEntity<List<ProductDTO>> response = productController.getProducts(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetProductsWithPagination(){
        Mockito.when(productService.getProductsOfThePage(0,5))
                .thenReturn(productsList);

        ResponseEntity<List<ProductDTO>> response = productController.getProducts(0,5);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
