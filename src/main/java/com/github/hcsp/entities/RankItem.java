package com.github.hcsp.entities;

import java.io.Serializable;

public class RankItem implements Serializable {
    String goods_name;
    int total_price;

    public RankItem() {
    }

    public RankItem(String goods_name, int total_price) {
        this.goods_name = goods_name;
        this.total_price = total_price;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
