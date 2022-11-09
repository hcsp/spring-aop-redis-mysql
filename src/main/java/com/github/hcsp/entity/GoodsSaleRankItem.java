package com.github.hcsp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class GoodsSaleRankItem implements Serializable {
    private int goodsId;
    private String goodsName;
    private BigDecimal sales;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GoodsSaleRankItem that = (GoodsSaleRankItem) o;
        return goodsId == that.goodsId && Objects.equals(goodsName, that.goodsName) && Objects.equals(sales, that.sales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, sales);
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
