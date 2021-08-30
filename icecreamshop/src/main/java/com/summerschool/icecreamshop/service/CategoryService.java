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

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> get(Long id) {
        return categoryRepository.findById(id);
    }

    public Category patch(Category newCategory, Category oldCategory)
    {
        Category patched = oldCategory;

        patched.setId(newCategory.getId()==null?oldCategory.getId():newCategory.getId());
        patched.setName(newCategory.getName()==null?oldCategory.getName():newCategory.getName());
        patched.setDescription(newCategory.getDescription()==null?oldCategory.getDescription():newCategory.getDescription());
        patched.setProducts(newCategory.getProducts()==null?oldCategory.getProducts():newCategory.getProducts());

        return categoryRepository.save(patched);


    }


}
