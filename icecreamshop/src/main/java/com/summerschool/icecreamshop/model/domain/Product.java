package com.summerschool.icecreamshop.model.domain;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @Column(length = 100)
    private String shortDescription;

    @NotNull
    @Column(length = 500)
    private String longDescription;

    @NotNull
    @ElementCollection
    private List<String> ingredients;

    @NotNull
    private int quantity;

    @NotNull
    @ElementCollection
    private List<String> alergens;

    @NotNull
    private double price;

    @NotNull
    private String currency;

    @NotNull
    @ElementCollection
    private List<String> photo_urls;

    @NotNull
    Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rate> rates;


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAlergens(List<String> alergens) {
        this.alergens = alergens;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPhoto_urls(List<String> photo_urls) {
        this.photo_urls = photo_urls;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> getAlergens() {
        return alergens;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public List<String> getPhoto_urls() {
        return photo_urls;
    }

    public Type getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public List<Rate> getRates() {
        return rates;
    }
}