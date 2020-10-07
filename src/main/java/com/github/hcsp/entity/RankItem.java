package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private Goods goods;
    private int earnings;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}
