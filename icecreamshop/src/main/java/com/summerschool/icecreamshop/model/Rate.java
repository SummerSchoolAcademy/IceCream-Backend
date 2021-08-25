package com.summerschool.icecreamshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Product> product;

    @NotNull
    private int rate; // 0-5

    public Rate() {

    }

    public Rate(Long id, List<Product> product, int rate) {
        this.id = id;
        this.product = product;
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public int getRate() {
        return rate;
    }
}