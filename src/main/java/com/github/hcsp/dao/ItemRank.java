/**
 * 
 */
package com.github.hcsp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author sunp
 *
 */

@Component
public class ItemRank {
    
    private String itemName;
    
    private int totalAmount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}
