package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Goods goods;
    private int price;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
