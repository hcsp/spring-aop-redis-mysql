package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int dealPrice;
    private Goods goods;

    public RankItem() {
    }

    public int getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(int dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
