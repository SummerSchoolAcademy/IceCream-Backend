package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAll() { return productRepository.findAll();}

    public List<Product> getProductsOfThePage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).toList();
    }
    public Product add(Long categoryId, Product product) {
        return productRepository.save(product);
    }

}
