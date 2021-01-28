package com.github.hcsp.entity;

public class Order {
    private Integer id;
    private Integer goods_id;
    private Integer user_id;
    private int price;
    private Long quantity;

    public Order() {
    }

    public Order(Integer id, Integer goods_id, Integer user_id, int price, Long quantity) {
        this.id = id;
        this.goods_id = goods_id;
        this.user_id = user_id;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
