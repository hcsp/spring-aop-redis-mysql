package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int amount;
    private Good good;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
