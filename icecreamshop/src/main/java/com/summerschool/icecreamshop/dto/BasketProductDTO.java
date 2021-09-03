package com.summerschool.icecreamshop.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class BasketProductDTO {
    Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;


    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //public void setProduct(ProductDTO product){this.product=product;}


    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    //public ProductDTO getProduct(){return product;}
}
