package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {

    private int totalGoods;

    private String goodsName;

    public int getTotalGoods() {
        return totalGoods;
    }

    public void setTotalGoods(int totalGoods) {
        this.totalGoods = totalGoods;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

}
