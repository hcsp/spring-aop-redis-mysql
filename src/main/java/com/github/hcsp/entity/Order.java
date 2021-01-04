package com.github.hcsp.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author Ruby
 * @date 2021/1/3 21:52
 */
@TableName("`order`")
public class Order {
    private int id;
    private int goodsId;
    private int userId;
    private BigDecimal price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", userId=").append(userId);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
