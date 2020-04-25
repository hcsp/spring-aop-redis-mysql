package com.github.hcsp.entity;

import java.io.Serializable;

public class RankItem implements Serializable {
    private String itemName;
    private Integer itemSalesAmount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemSalesAmount() {
        return itemSalesAmount;
    }

    public void setItemSalesAmount(Integer itemSalesAmount) {
        this.itemSalesAmount = itemSalesAmount;
    }
}
