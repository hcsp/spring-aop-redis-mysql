package com.github.hcsp.entity;

import java.io.Serializable;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 12:16
 */
public class GoodsDealInfo implements Serializable {
    private String name;
    private long dealPrice;

    public GoodsDealInfo() {
    }

    public GoodsDealInfo(String name, long dealPrice) {
        this.name = name;
        this.dealPrice = dealPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(long dealPrice) {
        this.dealPrice = dealPrice;
    }

    @Override
    public String toString() {
        return "GoodsDealInfo{" +
                "name='" + name + '\'' +
                ", dealPrice=" + dealPrice +
                '}';
    }
}
