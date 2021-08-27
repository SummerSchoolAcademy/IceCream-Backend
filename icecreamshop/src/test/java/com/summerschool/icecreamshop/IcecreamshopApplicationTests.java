package com.summerschool.icecreamshop;

import com.summerschool.icecreamshop.controller.CategoryController;
import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
class IcecreamshopApplicationTests {
	@Mock
	CategoryDTO categoryDTO;

	@InjectMocks
	CategoryService categoryService;

	@Mock
	ModelMapper modelMapper;

	@InjectMocks
	CategoryController categoryController;

	@Mock
	CategoryService cs;


	@Test
	public void categoryServiceTest() {
		Category category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>());
		assertEquals(category.getName(), categoryService.add(category).getName());
	}


	@Test
	public void setCategoryControllerTest() {
		Category category = new Category(5L, "Test Name", "ceva", new ArrayList<Product>());

		Mockito.when(modelMapper.map(categoryDTO, Category.class)).thenReturn(category);
		Mockito.when(cs.add(category)).thenReturn(category);

		ResponseEntity<CategoryDTO> c = categoryController.add(categoryDTO);

		assertEquals(HttpStatus.CREATED, c.getStatusCode());
	}


	@Test
	void contextLoads() {
	}



}
