package com.github.hcsp.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private String name;
    private int totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
