package com.github.hcsp.entity;

import java.io.Serializable;

public class RankingList implements Serializable {
        private String goodsName;
    private int Turnover;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getTurnover() {
        return Turnover;
    }

    public void setTurnover(int turnover) {
        this.Turnover = turnover;
    }
}
