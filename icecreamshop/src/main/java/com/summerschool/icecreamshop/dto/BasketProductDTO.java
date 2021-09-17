package com.summerschool.icecreamshop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.summerschool.icecreamshop.model.Product;

import javax.validation.constraints.NotNull;

public class BasketProductDTO {

    Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Product product;

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product){this.product=product;}

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct(){return product;}
}
