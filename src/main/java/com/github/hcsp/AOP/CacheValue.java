package com.github.hcsp.AOP;

import com.github.hcsp.Order;

import java.io.Serializable;
import java.util.List;

public class CacheValue implements Serializable {
    private long expired;
    private List<Order> value;

    public CacheValue(long expired, List<Order> value) {
        this.expired = expired;
        this.value = value;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
    }

    public List<Order> getValue() {
        return value;
    }

    public void setValue(List<Order> value) {
        this.value = value;
    }
}
