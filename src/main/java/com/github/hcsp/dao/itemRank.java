/**
 * 
 */
package com.github.hcsp.dao;

import java.util.List;

/**
 * @author sunp
 *
 */
public class itemRank {
    
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
    
    public List<itemRank> queryItemRank() {
        
    }

}
