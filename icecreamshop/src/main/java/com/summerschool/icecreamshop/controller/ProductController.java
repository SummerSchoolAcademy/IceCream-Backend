package com.summerschool.icecreamshop.controller;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.service.CategoryService;
import com.summerschool.icecreamshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.summerschool.icecreamshop.exception.Constants.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private ModelMapper modelMapper;

    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper, CategoryService categoryService){
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @PostMapping("/{categoryId}")
    public ResponseEntity<ProductDTO> add(@PathVariable("categoryId") Long categoryId, @Valid @RequestBody ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Category productCategory = categoryService.get(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORY_NOT_FOUND));
        product.setCategory(productCategory);
        Product savedProduct = productService.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedProduct, ProductDTO.class));
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

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) throws IllegalAccessException {
        Product foundProduct = productService.get(id).orElseThrow(()-> new ResponseStatusException((HttpStatus.NOT_FOUND), PRODUCT_NOT_FOUND));
        productDTO.setId(id);
        validatePatchRequestBody(productDTO);
        Product updateProduct = productService.patch(modelMapper.map(productDTO,Product.class), foundProduct);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(updateProduct, ProductDTO.class));
    }

    void validatePatchRequestBody(ProductDTO productDTO) throws IllegalAccessException {
        if(productDTO == null) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), BAD_REQUEST);
        }
        Field[] fields = productDTO.getClass().getDeclaredFields();
        boolean flag = false;
        for (Field field : fields)
        {
            field.setAccessible(true);
            Object value = field.get(productDTO);
            if (value != null) {
                flag = true;
            }
        }
        if(!flag) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable("id") Long id){
        Product product = productService.get(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(modelMapper.map(product, ProductDTO.class));
    }
}