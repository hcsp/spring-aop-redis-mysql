package com.github.hcsp.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer goodsId;
    private String goodsName;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
