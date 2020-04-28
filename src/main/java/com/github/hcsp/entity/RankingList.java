package com.github.hcsp.entity;

import java.io.Serializable;

public class RankingList implements Serializable {
    private String goodsName;
    private Integer Turnover;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getTurnover() {
        return Turnover;
    }

    public void setTurnover(Integer turnover) {
        this.Turnover = turnover;
    }
}
