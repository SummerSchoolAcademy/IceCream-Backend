package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;


    Page<Product> productsPage;

    Product product1 = new Product();

    Product productPatch = new Product();

    Category category1 = new Category();

    List<Product> productsList;

    @Before
    public void setup(){
        initMocks(this);

        category1.setName("Gelato");
        category1.setDescription("Cool yourself on a hot summer day with our gelato!");

        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setType(Type.DONUTS);
        product1.setPrice(2.5);
        product1.setCategory(category1);
        product1.setHowManyAlergens(0);

        productPatch.setTitle("test-title");

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

    @Test
    public void testServiceForGetSpecialProducts(){

        productsList= new ArrayList<Product>();
        productsList.add(product1);

        Mockito.when(productRepository.querySpecialProducts())
                .thenReturn(productsList);

        List<Product> response = productService.getSpecialProducts();

        assertNotNull(response);
        assertEquals(1,response.size());
    }

    @Test
    public  void testServiceForAddProduct(){

        Mockito.when(productRepository.save(product1))
                .thenReturn(product1);

        Product response = productService.add(product1);
        assertEquals(product1, response);
    }

    @Test
    public void patchProductTest() {
        Mockito.when(productService.patch(productPatch, product1)).thenReturn(product1);
        Mockito.when(productRepository.save(product1)).thenReturn(productPatch);
        assertEquals(productRepository.save(product1).getTitle(), productPatch.getTitle());
    }
}