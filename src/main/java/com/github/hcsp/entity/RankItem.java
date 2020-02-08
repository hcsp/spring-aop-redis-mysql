package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankItem implements Serializable {
    private String name;
    private BigDecimal totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
