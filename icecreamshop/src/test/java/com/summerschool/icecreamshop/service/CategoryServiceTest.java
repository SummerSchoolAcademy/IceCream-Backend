package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.domain.Category;
import com.summerschool.icecreamshop.model.domain.Product;
import com.summerschool.icecreamshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
}
