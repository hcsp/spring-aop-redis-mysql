package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private String name;
    private int gmv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGmv() {
        return gmv;
    }

    public void setGmv(int gmv) {
        this.gmv = gmv;
    }
}
