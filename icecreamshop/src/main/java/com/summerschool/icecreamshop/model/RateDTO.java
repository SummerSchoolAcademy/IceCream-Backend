package com.summerschool.icecreamshop.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "rates")
public class RateDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductDTO product;

    @NotNull
    private int rate; // 0-5

    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public int getRate() {
        return rate;
    }
}