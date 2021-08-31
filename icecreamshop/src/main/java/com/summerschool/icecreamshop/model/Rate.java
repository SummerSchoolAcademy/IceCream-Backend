package com.summerschool.icecreamshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private Integer rate; // 0-5


    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getRate() {
        return rate;
    }
}