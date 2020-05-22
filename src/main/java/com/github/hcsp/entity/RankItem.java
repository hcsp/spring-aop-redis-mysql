package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Goods goods;
    private Integer totalAmount;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
