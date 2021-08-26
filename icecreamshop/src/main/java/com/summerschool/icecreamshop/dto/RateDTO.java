package com.summerschool.icecreamshop.dto;

import com.summerschool.icecreamshop.model.Product;
import javax.validation.constraints.NotNull;

public class RateDTO {
    private Long id;

    private ProductDTO productDTO;

    @NotNull
    private int rate; // 0-5

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public int getRate() {
        return rate;
    }
}
