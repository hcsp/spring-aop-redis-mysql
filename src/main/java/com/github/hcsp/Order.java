package com.github.hcsp;

import java.io.Serializable;

public class Order implements Serializable {
    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String goods;

    private int price;
}
