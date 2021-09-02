package com.summerschool.icecreamshop.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basket_products")
public class BasketProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductDTO product;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private BasketDTO basket;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBasket(BasketDTO basket) {
        this.basket = basket;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public BasketDTO getBasket() {
        return basket;
    }
}
