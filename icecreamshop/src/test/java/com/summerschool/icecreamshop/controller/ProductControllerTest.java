package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
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
    public void testGetProductsWithPagination(){
        Mockito.when(productService.getProductsOfThePage(0,5))
                .thenReturn(productsList);

        ResponseEntity<List<ProductDTO>> response = productController.getProducts(0,5);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetProductsWithPaginationThrowsError(){
        assertThrows(IllegalArgumentException.class ,() -> productController.getProducts(null,5));
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


        Mockito.when(productService.add(category1.getId(), product10))
                .thenReturn(product10);

        Product response = productController.add(category1.getId() ,product10);
        assertEquals(product10, response);
    }
}
