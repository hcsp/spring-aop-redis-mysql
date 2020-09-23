package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankItem implements Serializable {
    private Goods goods;
    private BigDecimal totalPrice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
