package com.github.hcsp.entity;

import java.io.Serializable;
import java.time.Instant;

public class CacheValue implements Serializable {
    private Instant cacheTime;
    private Object value;

    public CacheValue(Instant cacheTime, Object value) {
        this.cacheTime = cacheTime;
        this.value = value;
    }

    public Instant getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(Instant cacheTime) {
        this.cacheTime = cacheTime;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CacheValue{" +
                "cacheTime=" + cacheTime +
                ", value=" + value +
                '}';
    }
}
