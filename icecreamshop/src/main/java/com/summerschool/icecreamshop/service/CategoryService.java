package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    public Category getCategoryByID(Long id) {
//        return this.categoryRepository
//                .getById(id);
//    }
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> get(Long id) {
        return categoryRepository.findById(id);
    }

}
