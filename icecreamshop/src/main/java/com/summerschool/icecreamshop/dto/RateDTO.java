package com.summerschool.icecreamshop.dto;

import javax.validation.constraints.NotNull;

public class RateDTO {
    private Long id;

    @NotNull
    private Integer rate; // 0-5

    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public Integer getRate() {
        return rate;
    }
}
