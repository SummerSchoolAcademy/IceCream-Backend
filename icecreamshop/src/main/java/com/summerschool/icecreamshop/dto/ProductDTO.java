package com.summerschool.icecreamshop.dto;

import com.summerschool.icecreamshop.model.Type;

import javax.persistence.ElementCollection;
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
    @ElementCollection
    private List<String> photoUrlsBig;

    @NotNull
    @ElementCollection
    private List<String> photoUrlsMedium;

    @NotNull
    @ElementCollection
    private List<String> photoUrlsSmall;

    @NotNull
    Type type;

    private List<RateDTO> rates;

    private List<BasketProductDTO> basketProduct;

    //Constructors
    public ProductDTO(){}

    public ProductDTO(Long id, String title, String shorDesc, String longDesc, List<String> ingredients,
                      int quantity, List <String> alergens, double price, String currency, List<String> photoUrlsBig, List<String> photoUrlsMedium, List<String> photoUrlsSmall, Type type){
        this.id = id;
        this.title = title;
        this.shortDescription = shorDesc;
        this.longDescription = longDesc;
        this.alergens = alergens;
        this.price = price;
        this.photoUrlsBig = photoUrlsBig;
        this.photoUrlsMedium= photoUrlsMedium;
        this.photoUrlsSmall = photoUrlsSmall;
        this.type = type;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.currency = currency;
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

    public void setPhotoUrlsBig(List<String> photoUrls) {
        this.photoUrlsBig = photoUrls;
    }

    public void setPhotoUrlsMedium(List<String> photoUrls) {
        this.photoUrlsMedium = photoUrls;
    }

    public void setPhotoUrlsSmall(List<String> photoUrls) {
        this.photoUrlsSmall = photoUrls;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRates(List<RateDTO> rates) {
        this.rates = rates;
    }

    public void setBasketProduct(List<BasketProductDTO> basketProduct) {
        this.basketProduct = basketProduct;
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

    public List<String> getPhotoUrlsBig() {
        return photoUrlsBig;
    }

    public List<String> getPhotoUrlsMedium() {
        return photoUrlsMedium;
    }

    public List<String> getPhotoUrlsSmall() {
        return photoUrlsSmall;
    }

    public Type getType() {
        return type;
    }

    public List<RateDTO> getRates() {
        return rates;
    }

    public List<BasketProductDTO> getBasketProduct() {
        return basketProduct;
    }
}
