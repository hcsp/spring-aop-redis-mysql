package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankItem implements Serializable {
    private Goods goods;
    private BigDecimal turnover = BigDecimal.ZERO;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }
}
