package com.summerschool.icecreamshop.dto;

import com.summerschool.icecreamshop.model.Type;
import javax.validation.constraints.NotNull;
import java.util.List;


public class ProductDTO {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String shortDescription;

    @NotNull
    private String longDescription;

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

    private List<RateDTO> rates;


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

    public void setRates(List<RateDTO> rates) {
        this.rates = rates;
    }


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

    public List<RateDTO> getRates() {
        return rates;
    }
}
