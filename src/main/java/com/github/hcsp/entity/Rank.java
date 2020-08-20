package com.github.hcsp.entity;

import java.io.Serializable;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 13:58
 * @version: 1.0
 * @since: JDK 8
 */
public class Rank implements Serializable {
    String name;
    Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
