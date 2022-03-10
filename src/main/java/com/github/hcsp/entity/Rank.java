package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Rank implements Serializable {
    private String goodName;
    private BigDecimal totalPrice;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal gettotalPrice() {
        return totalPrice;
    }

    public void settotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
