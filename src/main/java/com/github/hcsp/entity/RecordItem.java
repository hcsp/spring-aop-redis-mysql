package com.github.hcsp.entity;


public class RecordItem {
    private Goods goods;
    private int price;

    public RecordItem() {
    }

    public RecordItem(Goods goods, int price) {
        this.goods = goods;
        this.price = price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
