package com.github.hcsp.entity;

import java.io.Serializable;

// Serializable 使 RankItem 可序列到存储到 redis 中
public class RankItem implements Serializable {
    String goodsName;
    int priceSum;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(int priceSum) {
        this.priceSum = priceSum;
    }
}
