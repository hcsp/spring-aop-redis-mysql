package com.github.hcsp.Entity;

/**
 * @Author: GoFocus
 * @Date: 2020-05-26 14:24
 * @Description:
 */
public class SaleOrder {

    private String goodsName;
    private Integer totalPrice;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
