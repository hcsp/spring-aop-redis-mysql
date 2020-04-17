package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int id;
    private String name;
    private int prices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }
}
