package com.summerschool.icecreamshop.model.dto;

import com.summerschool.icecreamshop.model.Type;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDTO {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String shortDescription;

    @NotNull String longDescription;

    @NotNull
    private List<String> ingredients;


    @NotNull
    private int quantity;

    @NotNull
    private List<String> alergens;

    @NotNull
    private double price;

    @NotNull
    private String currency;

    @NotNull
    private List<String> photo_urls;

    @NotNull
    Type type;

    public ProductDTO(Long id, String title, String shorDesc, String longDesc, List<String> ingredients,
                      int quantity, List <String> alergens, double price, String curreny, List<String> photoUrls, Type type){
        this.id = id;
        this.title = title;
        this.shortDescription = shorDesc;
        this.longDescription = longDesc;
        this.alergens = alergens;
        this.price = price;
        this.photo_urls = photoUrls;
        this.type = type;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.currency = curreny;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public List<String> getAlergens() {
        return alergens;
    }

    public void setAlergens(List<String> alergens) {
        this.alergens = alergens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getPhoto_urls() {
        return photo_urls;
    }

    public void setPhoto_urls(List<String> photo_urls) {
        this.photo_urls = photo_urls;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
