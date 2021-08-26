package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.dto.CategoryDTO;
import com.summerschool.icecreamshop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static com.summerschool.icecreamshop.exception.Constants.CATEGORY_NOT_FOUND;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private CategoryService categoryService;

    private ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDTO> get(@PathVariable("categoryId") Long id) {
        Category category = categoryService.get(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORY_NOT_FOUND));

        return ResponseEntity.ok(modelMapper.map(category, CategoryDTO.class));
    }

}
