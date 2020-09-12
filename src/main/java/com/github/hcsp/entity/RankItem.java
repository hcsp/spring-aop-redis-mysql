package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Goods goods;
    private int totalPrice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
