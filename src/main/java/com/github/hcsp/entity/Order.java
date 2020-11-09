package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    private Integer id;
    private String goodsName;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", goodsName='" + goodsName + '\'' +
               ", totalPrice=" + totalPrice +
               '}';
    }
}
