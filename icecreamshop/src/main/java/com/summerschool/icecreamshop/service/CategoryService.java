package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByID(Long id) {
        return this.categoryRepository
                .getById(id);
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
