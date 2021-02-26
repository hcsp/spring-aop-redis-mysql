package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankItem implements Serializable {
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

    @Override
    public String toString() {
        return "RankItem{" +
                "goods=" + goods +
                ", price=" + price +
                '}';
    }
}
