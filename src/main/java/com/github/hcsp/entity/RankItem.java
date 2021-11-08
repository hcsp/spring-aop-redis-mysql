package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int total;
    private String name;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
