package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.service.CategoryService;
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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductControllerTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    ProductService productService;

    @Mock
    CategoryService categoryService;

    @InjectMocks
    ProductController productController;

    List<Product> productsList;

    Product product1 = new Product();

    Category category1 = new Category();

    ProductDTO productDTO = new ProductDTO();

    @Before
    public void setup() {
        initMocks(this);

        category1.setId(1L);
        category1.setName("Gelato");
        category1.setDescription("Cool yourself on a hot summer day with our gelato!");


        product1.setTitle("Chocolate Mix Donuts");
        product1.setQuantity(100);
        product1.setPrice(2.5);
        product1.setType(Type.DONUTS);
        product1.setCategory(category1);

        productDTO.setTitle("Chocolate Mix Donuts");
        productDTO.setQuantity(100);
        productDTO.setPrice(2.5);
        productDTO.setType(Type.DONUTS);

        productsList = new ArrayList<Product>();
        productsList.add(product1);


    }

    @Test
    public void testGetAllProducts() {
        Mockito.when(productService.getAll())
                .thenReturn(productsList);

        ResponseEntity<List<ProductDTO>> response = productController.getProducts(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetProductsWithPagination() {
        Mockito.when(productService.getProductsOfThePage(0, 5))
                .thenReturn(productsList);

        ResponseEntity<List<ProductDTO>> response = productController.getProducts(0, 5);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testServiceForAddProduct() {

        Mockito.when(modelMapper.map(productDTO,Product.class))
                .thenReturn(product1);
        Mockito.when(categoryService.get(category1.getId()))
                .thenReturn(Optional.of(category1));
        Mockito.when(productService.add(product1))
                .thenReturn(product1);
        Mockito.when(modelMapper.map(product1, ProductDTO.class))
                .thenReturn(productDTO);

        ResponseEntity response = productController.add(category1.getId(), productDTO);
        assertEquals(productDTO, response.getBody());
    }
}
