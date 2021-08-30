package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.repository.CategoryRepository;
import com.summerschool.icecreamshop.model.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
