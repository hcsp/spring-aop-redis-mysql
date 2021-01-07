package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int sales;
    private Goods goods;

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
