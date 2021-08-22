package com.github.hcsp.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class GoodsSalesRankItem {
    private int goodsId;
    private String goodsName;
    private BigDecimal sales;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSalesRankItem goodsSalesRankItem = (GoodsSalesRankItem) o;
        return goodsId == goodsSalesRankItem.goodsId && Objects.equals(goodsName, goodsSalesRankItem.goodsName) && Objects.equals(sales, goodsSalesRankItem.sales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, sales);
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

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }
}
