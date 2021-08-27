package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.exception.InvalidPage;
import com.summerschool.icecreamshop.model.domain.Product;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.summerschool.icecreamshop.exception.InvalidPage;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductService {

    @Autowired
    private ProductRepository productsRepository;

    public List<Product> getProductsOfThePage(Integer page, Integer size){

        if (page != null) {
            Pageable pageable = PageRequest.of(page, size);
            return productsRepository.findAll(pageable).toList();
        }

        return productsRepository.findAll();
    }
}
