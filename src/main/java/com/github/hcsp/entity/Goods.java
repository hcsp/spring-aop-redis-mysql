package com.github.hcsp.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    Integer rankNumber;
    String name;
    Integer allPrice;

    public Goods(Integer rankNumber, String name, Integer allPrice) {
        this.rankNumber = rankNumber;
        this.name = name;
        this.allPrice = allPrice;
    }

    public Integer getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(Integer rankNumber) {
        this.rankNumber = rankNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Integer allPrice) {
        this.allPrice = allPrice;
    }
}
