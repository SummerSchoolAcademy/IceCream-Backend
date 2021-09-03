package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAll() { return productRepository.findAll();}

    public List<Product> getProductsOfThePage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).toList();
    }
    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product patch(Product newProduct, Product oldProduct) {
        Product patched = null;
        try {
            patched = Product.mergeObjects(newProduct,oldProduct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return productRepository.save(patched);
    }

}
