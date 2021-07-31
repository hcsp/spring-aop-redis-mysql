package com.github.hcsp.entity;


import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsRank implements Serializable {
    private String goodName;
    private BigDecimal total;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
