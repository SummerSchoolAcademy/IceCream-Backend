package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    Category category;

    @Before
    public void setUp() {
        category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>());
    }

    @Test
    public void categoryAddTest() {
        Mockito.when(categoryRepository.save(category)).thenReturn(category);
        assertEquals(category.getName(), categoryService.add(category).getName());
    }

    @Test
    public void testGetCategoryByValidId() {
        Mockito.when(categoryRepository.findById(category.getId())).thenReturn(Optional.ofNullable(category));
        Category actualCategory = categoryService.get(category.getId()).get();

        assertEquals(category.getId(), actualCategory.getId());
        assertEquals(category.getName(), actualCategory.getName());
        assertEquals(category.getDescription(), actualCategory.getDescription());
    }
    @Test
    public void categoryPatchTest() {
        Mockito.when(categoryRepository.save(category)).thenReturn(category);
        assertEquals(category.getName(), categoryService.add(category).getName());
    }


    @Test
    public void testGetCategoryByInvalidId() {
        assertTrue(!categoryService.get(-1L).isPresent());
    }

}
