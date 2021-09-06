package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.model.dto.ProductDTO;
import com.summerschool.icecreamshop.service.ProductService;
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
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductEndpointControllerTest {
    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    Product product;
    ProductDTO productDTO;

    @Before
    public void setUp() {
        List<String> alergens = new ArrayList<String>();
        List<String> urls = new ArrayList<String>();
        List<String> ingredients = new ArrayList<String>();
        alergens.add("alergen1");
        alergens.add("alergen2");

        urls.add("url1");
        urls.add("url2");

        ingredients.add("ing1");
        ingredients.add("ing2");

        product = new Product(100L, "title",
                "shortDesc", "longDesc", ingredients, 1, alergens,
                10, "RON", urls, Type.GELATO);
        productDTO = new ProductDTO(100L, "title",
                "shortDesc", "longDesc", ingredients, 1, alergens,
                  10, "RON", urls, Type.GELATO);
    }


    @Test
    public void testGetProductAndModelMapper() {
        Long id = 105L;
        Mockito.when(modelMapper.map(productDTO, Product.class)).thenReturn(product);
        Mockito.when(productService.get(id)).thenReturn(java.util.Optional.ofNullable(product));

        ResponseEntity<ProductDTO> response = productController.get(id);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetProductByIdNotFound(){
        Long id = 1000L;
        try {
            ResponseEntity<ProductDTO> response = productController.get(id);
            System.out.println(response.getStatusCode());
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
        catch(Exception ex){
            assertEquals(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        }
    }

    @Test
    public void testGetProductByIdOK(){
        Long id = 1L;
        try {
            ResponseEntity<ProductDTO> response = productController.get(id);
            System.out.println(response.getStatusCode());
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
        catch(Exception ex){
            assertEquals(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        }
    }

    @Test
    public void givenProductId_returnProduct(){
        ProductDTO testProduct = this.productDTO;
        Long id = testProduct.getId();
        ResponseEntity<ProductDTO> response = productController.get(id);
        ProductDTO result = response.getBody();

    }
}
