package com.github.hcsp.entity;

import java.math.BigDecimal;

public class Order {
    private int id; //id
    private int goodsID;    //商品id
    private int userID;     //用户id
    private BigDecimal price;   //价格
    private int quantity;   //数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
