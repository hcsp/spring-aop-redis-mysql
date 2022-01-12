package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {

    private String name;
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
