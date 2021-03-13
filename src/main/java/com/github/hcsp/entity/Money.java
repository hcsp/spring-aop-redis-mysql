package com.github.hcsp.entity;

import java.io.Serializable;

public class Money implements Serializable {
    private Goods goods;
    private long moneyAggregate;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getMoneyAggregate() {
        return moneyAggregate;
    }

    public void setMoneyAggregate(long moneyAggregate) {
        this.moneyAggregate = moneyAggregate;
    }

    public Money() {
    }
}
