package com.github.hcsp.entity;

import java.io.Serializable;

public class cacheMapValue implements Serializable {
    private Object value;
    private long createdTime;

    public cacheMapValue(Object realValue, long currentTimeMillis) {
        this.value = realValue;
        this.createdTime = currentTimeMillis;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
