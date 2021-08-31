package com.summerschool.icecreamshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String session_id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BasketProduct> basketProduct;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBasketProduct(List<BasketProduct> basketProduct) {
        this.basketProduct = basketProduct;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Long getId() {
        return id;
    }

    public List<BasketProduct> getBasketProduct() {
        return basketProduct;
    }

    public String getSession_id() {
        return session_id;
    }
}
