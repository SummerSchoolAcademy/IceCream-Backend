package com.summerschool.icecreamshop.dto;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BasketProductDTO {

    Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;

    @ElementCollection
    private List<String> photoUrls;

    @NotNull
    private String title;


    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhotoUrls(List<String> photoUrls) {this.photoUrls=photoUrls;}


    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getPhotoUrls(){ return photoUrls;}

}
