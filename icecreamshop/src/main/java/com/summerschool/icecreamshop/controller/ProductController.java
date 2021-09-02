package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper){
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getProducts(
            @RequestParam(value="page", required = false) Integer page,
            @RequestParam(value="size", required = false) Integer size
    ){

        if(page == null){
            return ResponseEntity.ok(productService.getAll()
                    .stream()
                    .map(product -> modelMapper.map(product, ProductDTO.class))
                    .collect(Collectors.toList()));
        }
        if(size == null){
            size=10;
        }

        return ResponseEntity.ok(productService.getProductsOfThePage(page, size)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList()));
    }
}