package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Rankitem implements Serializable {
    private String name;
    private BigDecimal money;


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
