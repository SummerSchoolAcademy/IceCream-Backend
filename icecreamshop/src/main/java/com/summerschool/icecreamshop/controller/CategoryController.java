package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.exception.MyResourceBadRequestException;
import com.summerschool.icecreamshop.service.CategoryService;
import com.summerschool.icecreamshop.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("./categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok(categoryService.getAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable("id") Long id) {
        Category category =  categoryService.get(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found exception"));

        return ResponseEntity.ok(modelMapper.map(category, CategoryDTO.class));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);

        try {
            Category savedCategory = categoryService.add(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedCategory, CategoryDTO.class));
        }
        catch (MyResourceBadRequestException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category bad request exception", e);
        }
    }
}
