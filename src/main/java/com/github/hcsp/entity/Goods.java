package com.github.hcsp.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Goods(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    private String name;
    private String amount;
}
