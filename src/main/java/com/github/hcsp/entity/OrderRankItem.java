package com.github.hcsp.entity;

import java.io.Serializable;

public class OrderRankItem implements Serializable {
    int totalPrice;
    Goods goods;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
