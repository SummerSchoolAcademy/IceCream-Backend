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
import java.util.List;
import java.util.Optional;

import static com.summerschool.icecreamshop.exception.Constants.CATEGORY_NOT_FOUND;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

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

    List<Category> categoriesList;

    @Before
    public void setUp() {
        initMocks(this);

        List<String> pozeTest = new ArrayList<String>();

        pozeTest.add("poze");

        category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>(),pozeTest,pozeTest);
        categoryDTO = new CategoryDTO(5L, "Test Name", "ceva", new ArrayList<ProductDTO>(),pozeTest,pozeTest);
    }

    @Test
    public void testCreateCategory() {

        Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(category);
        Mockito.when(cs.add(category)).thenReturn(category);

        ResponseEntity<CategoryDTO> c = categoryController.add(categoryDTO);

        assertEquals(HttpStatus.CREATED, c.getStatusCode());
    }

    @Test
    public void testCreateCategory_failedToCreate(){

        Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(category);
        Mockito.when(cs.add(category)).thenReturn(null);
        ResponseEntity<CategoryDTO> responseEntity = categoryController.add(categoryDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testGetCategoryByValidId() {
        Mockito.when(modelMapper.map(category, CategoryDTO.class)).thenReturn(categoryDTO);
        Mockito.when(cs.get(category.getId())).thenReturn(Optional.of(category));

        ResponseEntity<CategoryDTO> c = categoryController.get(category.getId());
        assertEquals(HttpStatus.OK, c.getStatusCode());

        CategoryDTO actualCategory = c.getBody();
        assertEquals(category.getId(), actualCategory.getId());
        assertEquals(category.getName(), actualCategory.getName());
        assertEquals(category.getDescription(), actualCategory.getDescription());
    }

    @Test
    public void testGetCategoryByInvalidId() {
        Mockito.when(cs.get(-1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            categoryController.get(-1L);
        });

        assertTrue(exception.getMessage().contains(CATEGORY_NOT_FOUND));
    }
    @Test
    public void testPatchCategory(){
        Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(category);
        Mockito.when(cs.patch(category)).thenReturn(category);
        Mockito.when(cs.get(category.getId())).thenReturn(Optional.of(category));
        Mockito.when(modelMapper.map(category, CategoryDTO.class)).thenReturn(categoryDTO);

        ResponseEntity<CategoryDTO> c = categoryController.update(category.getId(),categoryDTO);

        assertEquals(HttpStatus.OK, c.getStatusCode());
    }
    @Test
    public void testPatchCategoryByInvalidId() {
        Mockito.when(cs.get(-1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            categoryController.update(-1L,categoryDTO);
        });

        assertTrue(exception.getMessage().contains(CATEGORY_NOT_FOUND));

        Mockito.when(cs.add(category)).thenReturn(category);

        ResponseEntity<CategoryDTO> c = categoryController.add(categoryDTO);

        assertEquals(HttpStatus.BAD_REQUEST, c.getStatusCode());
    }

    @Test
    public void testGetAllCategories() {
        categoriesList = new ArrayList<Category>();
        categoriesList.add(category);
        Mockito.when(cs.getAll())
                .thenReturn(categoriesList);

        ResponseEntity<List<CategoryDTO>> response = categoryController.getCategories();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
