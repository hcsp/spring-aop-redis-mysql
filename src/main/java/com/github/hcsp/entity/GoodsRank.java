package com.github.hcsp.entity;


import java.io.Serializable;

public class GoodsRank implements Serializable {
    private int total;

    private String goodsName;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
