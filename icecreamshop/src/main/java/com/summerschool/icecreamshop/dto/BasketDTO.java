package com.summerschool.icecreamshop.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BasketDTO {
    private Long id;

    @NotNull
    private String sessionId;

    private List<BasketProductDTO> basketProduct;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBasketProduct(List<BasketProductDTO> basketProduct) {
        this.basketProduct = basketProduct;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public List<BasketProductDTO> getBasketProduct() {
        return basketProduct;
    }

    public String getSessionId() {
        return sessionId;
    }
}