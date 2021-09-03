package com.summerschool.icecreamshop.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.lang.reflect.Field;
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
    private Integer quantity;

    @NotNull
    @ElementCollection
    private List<String> alergens;

    @NotNull
    private Double price;

    @NotNull
    private String currency;

    @NotNull
    @ElementCollection
    private List<String> photoUrls;

    @NotNull
    Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rate> rates;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BasketProduct> basketProduct;


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

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
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

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
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

    //probabil ar trebui mutata metoda altundeva
    //https://stackoverflow.com/questions/30782026/merging-one-object-into-another-object
    @SuppressWarnings("unchecked")
    public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = first.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Object returnValue = clazz.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value1 = field.get(first);
            Object value2 = field.get(second);
            Object value = (value1 != null) ? value1 : value2;
            field.set(returnValue, value);
        }
        System.out.println(returnValue.toString());
        return (T) returnValue;
    }
}