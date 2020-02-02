package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Rankitem implements Serializable {
    private int order;
    private String name;
    private BigDecimal money;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
