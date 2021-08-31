package com.summerschool.icecreamshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String session_id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BasketProduct> basketProduct;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBasketProduct(List<BasketProduct> basketProduct) {
        this.basketProduct = basketProduct;
    }

    public Long getId() {
        return id;
    }

    public List<BasketProduct> getBasketProduct() {
        return basketProduct;
    }
}
