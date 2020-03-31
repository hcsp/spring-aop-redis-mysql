package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Goods goods;
    private int amount;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
