package com.github.hcsp.entity;

import java.io.Serializable;

public class SalesRank implements Serializable {
    private Goods goods;
    private int sale;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }
}
