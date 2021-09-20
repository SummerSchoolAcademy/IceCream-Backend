package com.summerschool.icecreamshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(length = 500)
    private String description;

    @ElementCollection
    private List<String> categoryPhotoBig;

    @ElementCollection
    private List<String> categoryPhotoMedium;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products;

    public Category() {}

    public Category(Long id, String name, String description, List<Product> products, List<String> categoryPhotoBig, List<String> categoryPhotoMedium) {
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

    public void setProducts(List<Product> products) {
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

    public List<Product> getProducts() {
        return products;
    }


    public List<String> getCategoryPhotoBig() {
        return categoryPhotoBig;
    }

    public List<String> getCategoryPhotoMedium() {
        return categoryPhotoMedium;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products + '\'' +
                ", categoryPhotoBig=" + categoryPhotoBig + '\'' +
                ", categoryPhotoMedium=" + categoryPhotoMedium +
                '}';
    }
}