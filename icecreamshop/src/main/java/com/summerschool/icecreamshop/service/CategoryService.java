package com.summerschool.icecreamshop.service;

import com.summerschool.icecreamshop.repository.CategoryRepository;
import com.summerschool.icecreamshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> get(Long id) {
        return categoryRepository.findById(id);
    }

    public Category add(Category category) {
        category.setName(category.getName());
        return categoryRepository.save(category);
    }
}
