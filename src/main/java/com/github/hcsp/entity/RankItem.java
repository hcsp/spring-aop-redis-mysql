package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private String goodName;
    private int total;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
