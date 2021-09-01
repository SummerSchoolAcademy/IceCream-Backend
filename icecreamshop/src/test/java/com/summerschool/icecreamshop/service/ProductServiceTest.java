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

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void testServiceForGetProductsWithPagination(){

        Product product1 = new Product();
        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setType(Type.DONUTS);
        product1.setPrice(2.5);

        productsPage= new PageImpl<>(Arrays.asList(product1));

        Mockito.when(productRepository.findAll(any(Pageable.class)))
                .thenReturn(productsPage);


        List<Product> response = productService.getProductsOfThePage(0,5);

        assertNotNull(response);
        assertEquals(1,response.size());
    }

    @Test
    public  void testServiceForAddProduct(){
        Category category1 = new Category();
        category1.setName("Gelato");
        category1.setDescription("Cool yourself on a hot summer day with our gelato!");

        Product product10 = new Product();
        product10.setTitle("Marshmallow Donuts");
        product10.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product10.setLongDescription("Donut with strawberry icing, and marshmallows");
        product10.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Marshmallows", "Eggs"));
        product10.setQuantity(110);
        product10.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product10.setPrice(2.5);
        product10.setCurrency("USD");
        product10.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product10.setType(Type.DONUTS);
        product10.setCategory(category1);

        Mockito.when(productRepository.save(product10))
                .thenReturn(product10);

        Product response = productService.add(category1.getId() ,product10);
        assertEquals(product10, response);
    }
}