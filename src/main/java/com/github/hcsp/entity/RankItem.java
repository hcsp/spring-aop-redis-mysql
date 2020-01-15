package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem  implements Serializable {
    private String goodsName;
    private int amount;

    @Override
    public String toString() {
        return "RankItem{" +
                "goodsName='" + goodsName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
