package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Rank implements Serializable {
    private Goods goods;
    private BigDecimal price;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
