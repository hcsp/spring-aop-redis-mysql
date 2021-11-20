package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankItem implements Serializable {
    private String goodsName;
    private BigDecimal totalPrice;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
