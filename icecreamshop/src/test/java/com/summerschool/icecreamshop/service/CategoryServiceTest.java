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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    Category category;

    List<Category> categoriesList;

    @Before
    public void setUp() {

        List<String> pozeTest = new ArrayList<String>();

        pozeTest.add("poze");

        category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>(),pozeTest,pozeTest);

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
        assertFalse(categoryService.get(-1L).isPresent());
    }

    @Test
    public void testServiceForGetAllCategories(){
        categoriesList = new ArrayList<Category>();
        categoriesList.add(category);

        Mockito.when(categoryRepository.findAll())
                .thenReturn(categoriesList);

        List<Category> response = categoryService.getAll();

        assertNotNull(response);
    }

}
