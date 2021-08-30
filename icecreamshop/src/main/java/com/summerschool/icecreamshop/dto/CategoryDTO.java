package com.summerschool.icecreamshop.dto;

import com.sun.istack.NotNull;

import java.util.List;

public class CategoryDTO {
    private Long id;

    @NotNull
    private String name;

    private String description;

    private List<ProductDTO> products;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
