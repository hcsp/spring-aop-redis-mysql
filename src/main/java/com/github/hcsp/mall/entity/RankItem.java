package com.github.hcsp.mall.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int turnover;
    private Goods goods;

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
