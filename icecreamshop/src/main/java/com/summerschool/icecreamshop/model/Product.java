package com.summerschool.icecreamshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private Integer quantity;

    @NotNull
    @ElementCollection
    private List<String> alergens;

    @NotNull
    private Integer howManyAlergens;

    @NotNull
    private Double price;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Rate> rates;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BasketProduct> basketProduct;


    // Constructors
    public Product(){}

    public Product(Long id, String title, String shorDesc, String longDesc, List<String> ingredients,
                   int quantity, List <String> alergens, double price, String currency, List<String> photoUrlsBig, List<String> photoUrlsMedium, List<String> photoUrlsSmall, Type type, Integer howManyAlergens){
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
        this.howManyAlergens = howManyAlergens;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAlergens(List<String> alergens) {
        this.alergens = alergens;
    }

    public void setHowManyAlergens(Integer howManyAlergens) {
        this.howManyAlergens = howManyAlergens;
    }

    public void setPrice(Double price) {
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public void setBasketProduct(List<BasketProduct> basketProduct) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public List<String> getAlergens() {
        return alergens;
    }

    public Integer getHowManyAlergens() {
        return howManyAlergens;
    }

    public Double getPrice() {
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

    public Category getCategory() {
        return category;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public List<BasketProduct> getBasketProduct() {
        return basketProduct;
    }



}