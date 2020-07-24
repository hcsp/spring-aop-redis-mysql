/**
 * 
 */
package com.github.hcsp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author sunp
 *
 */

@Component
public class ItemRank implements Serializable {
    
    private static final long serialVersionUID = -1L;
    
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
