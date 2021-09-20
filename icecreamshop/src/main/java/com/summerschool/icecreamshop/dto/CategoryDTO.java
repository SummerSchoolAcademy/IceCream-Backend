package com.summerschool.icecreamshop.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CategoryDTO {
    private Long id;

    @NotNull
    private String name;

    private String description;

    private List<ProductDTO> products;

    private List<String> categoryPhotoBig;

    private List<String> categoryPhotoMedium;

    public CategoryDTO() {}

    public CategoryDTO(Long id, String name, String description, List<ProductDTO> products, List<String> categoryPhotoBig, List<String> categoryPhotoMedium) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
        this.categoryPhotoBig=categoryPhotoBig;
        this.categoryPhotoMedium=categoryPhotoMedium;
    }

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

    public void setCategoryPhotoBig(List<String> categoryPhotoBig) {
        this.categoryPhotoBig = categoryPhotoBig;
    }

    public void setCategoryPhotoMedium(List<String> categoryPhotoMedium) {this.categoryPhotoMedium = categoryPhotoMedium;}

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

    public List<String> getCategoryPhotoBig() {
        return categoryPhotoBig;
    }

    public List<String> getCategoryPhotoMedium() {
        return categoryPhotoMedium;
    }
}
