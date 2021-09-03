package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.service.CategoryService;
import com.summerschool.icecreamshop.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static com.summerschool.icecreamshop.exception.Constants.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    private ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);

        Category savedCategory = categoryService.add(category);
        if(savedCategory == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CategoryDTO());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedCategory, CategoryDTO.class));
    }

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDTO> get(@PathVariable("categoryId") Long id) {
        Category category = categoryService.get(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORY_NOT_FOUND));

        return ResponseEntity.ok(modelMapper.map(category, CategoryDTO.class));
    }
    @PatchMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("categoryId") Long id, @RequestBody @Valid CategoryDTO categoryDTO){
        categoryService.get(id)
                .orElseThrow(()-> new ResponseStatusException((HttpStatus.NOT_FOUND), CATEGORY_NOT_FOUND));

        categoryDTO.setId(id);

        Category updateCategory = categoryService.add(modelMapper.map(categoryDTO,Category.class));
        return ResponseEntity.ok(modelMapper.map(updateCategory, CategoryDTO.class));
    }

}
