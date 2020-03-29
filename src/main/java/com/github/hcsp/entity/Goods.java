package com.github.hcsp.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
