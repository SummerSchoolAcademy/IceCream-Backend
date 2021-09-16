package com.summerschool.icecreamshop.dto;

import javax.validation.constraints.NotNull;

public class BasketProductDTO {

    Long id;

    @NotNull
    private Integer quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
