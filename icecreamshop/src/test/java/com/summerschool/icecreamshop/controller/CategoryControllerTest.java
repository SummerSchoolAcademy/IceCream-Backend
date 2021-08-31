package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.service.CategoryService;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

import static com.summerschool.icecreamshop.exception.Constants.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryControllerTest {

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService cs;

    CategoryDTO categoryDTO;

    Category category;

    CategoryDTO categoryDTOInDb;

    Category categoryInDb;

    @Before
    public void setUp() {
        category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>());
        categoryDTO = new CategoryDTO(5L, "Test Name", "ceva", new ArrayList<ProductDTO>());
        categoryInDb = new Category(1L, "Gelato", "Cool yourself on a hot summer day with our gelato!", new ArrayList<Product>());
        categoryDTOInDb = new CategoryDTO(1L, "Gelato", "Cool yourself on a hot summer day with our gelato!", new ArrayList<ProductDTO>());
    }

    @Test
    public void testCreateCategory() {

        Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(category);
        Mockito.when(cs.add(category)).thenReturn(category);

        ResponseEntity<CategoryDTO> c = categoryController.add(categoryDTO);

        assertEquals(HttpStatus.CREATED, c.getStatusCode());
    }

    @Test
    public void testGetCategoryByValidId() {
        Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(categoryInDb);
        Mockito.when(cs.get(categoryInDb.getId())).thenReturn(Optional.ofNullable(categoryInDb));

        ResponseEntity<CategoryDTO> c = categoryController.get(categoryInDb.getId());
        assertEquals(HttpStatus.OK, c.getStatusCode());
    }

    @Test
    public void testGetCategoryByInvalidId() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            categoryController.get(-1L);
        });

        assertTrue(exception.getMessage().contains(CATEGORY_NOT_FOUND));
    }
}
