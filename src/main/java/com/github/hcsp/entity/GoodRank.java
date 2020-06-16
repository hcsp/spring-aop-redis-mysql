package com.github.hcsp.entity;

import java.io.Serializable;

public class GoodRank implements Serializable {

    private String name;
    private Integer amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
