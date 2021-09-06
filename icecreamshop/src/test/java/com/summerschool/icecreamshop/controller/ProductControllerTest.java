package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.service.CategoryService;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
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

    Product productPatch = new Product();

    Category category1 = new Category();

    ProductDTO productDTO = new ProductDTO();

    Product product;
    ProductDTO productDTOTest;
    @Before
    public void setup() {
        initMocks(this);

        category1.setId(1L);
        category1.setName("Gelato");
        category1.setDescription("Cool yourself on a hot summer day with our gelato!");

        product1.setId(1L);
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

        productPatch.setId(1L);
        productPatch.setTitle("test-title");

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
        productDTOTest = new ProductDTO(100L, "title",
                "shortDesc", "longDesc", ingredients, 1, alergens,
                10, "RON", urls, Type.GELATO);

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

    @Test
    public void testPatchProduct() throws IllegalAccessException {

        Mockito.when(productService.get(product1.getId())).thenReturn(Optional.of(product1));
        Mockito.when((modelMapper.map(productDTO,Product.class))).thenReturn(productPatch);
        product1.setTitle(productPatch.getTitle());
        Mockito.when(productService.patch(product1,productPatch)).thenReturn(product1);

        ResponseEntity<ProductDTO> p = productController.update(product1.getId(),productDTO);
        assertEquals(p.getStatusCode(), HttpStatus.OK);
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
    public void testGivenProductId_returnProduct(){
        Mockito.when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTOTest);
        Mockito.when(productService.get(product.getId())).thenReturn(Optional.of(product));

        ResponseEntity<ProductDTO> p = productController.get(product.getId());
        assertEquals(HttpStatus.OK, p.getStatusCode());

        ProductDTO realProduct = p.getBody();
        assertEquals(product.getId(), realProduct.getId());
        assertEquals(product.getLongDescription(), realProduct.getLongDescription());
        assertEquals(product.getShortDescription(), realProduct.getShortDescription());

    }

    @Test
    public void testGetProductByIdNotFound () {
        Long id = 1000L;
        try {
            ResponseEntity<ProductDTO> response = productController.get(id);
            System.out.println(response.getStatusCode());
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (Exception ex) {
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

}
