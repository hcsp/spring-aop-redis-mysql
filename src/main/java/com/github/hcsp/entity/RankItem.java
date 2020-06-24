package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private int rank;
    private int score;
    private Goods goods;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
