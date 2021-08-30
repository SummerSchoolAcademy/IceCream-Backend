package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.dto.CategoryDTO;
import com.summerschool.icecreamshop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    @PatchMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("categoryId") Long id, @RequestBody @Valid CategoryDTO categoryDTO){
            Category foundCategory = categoryService.get(id).orElseThrow(()-> new ResponseStatusException((HttpStatus.NOT_FOUND), CATEGORY_NOT_FOUND));
            System.out.println(foundCategory.toString());
            categoryDTO.setId(id);
            System.out.println(categoryDTO.toString());

            Category updateCategory = categoryService.patch(modelMapper.map(categoryDTO,Category.class), foundCategory);
            return ResponseEntity.ok(modelMapper.map(updateCategory, CategoryDTO.class));
        }

}
