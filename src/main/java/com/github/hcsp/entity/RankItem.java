package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Good good;
    private Integer totalPrice;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
