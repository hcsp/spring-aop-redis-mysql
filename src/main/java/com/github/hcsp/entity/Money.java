package com.github.hcsp.entity;

import java.io.Serializable;

public class Money implements Serializable {
    private Goods goods;
    private long totalMoney;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Money() {
    }
}
