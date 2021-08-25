package com.summerschool.icecreamshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(length = 30)
    private String shortDescription;

    @NotNull
    @Column(length = 500)
    private String longDescription;

    @NotNull
    private String ingredients;

    @NotNull
    private int quantity;

    @NotNull
    private String alergens;

    @NotNull
    private int price;

    @NotNull
    private String currency;

    @NotNull
    @ElementCollection
    private List<String> photo_URL;

    @NotNull
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {

    }

    public Product(Long id, String title, String shortDescription, String longDescription, String ingredients,
                   int quantity, String alergens, int price, String currency, List<String> photo_URL,
                   String type, Category category) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.alergens = alergens;
        this.price = price;
        this.currency = currency;
        this.photo_URL = photo_URL;
        this.type = type;
        this.category = category;
    }

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

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAlergens(String alergens) {
        this.alergens = alergens;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPhoto_URL(List<String> photo_URL) {
        this.photo_URL = photo_URL;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAlergens() {
        return alergens;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public List<String> getPhoto_URL() {
        return photo_URL;
    }

    public String getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }
}