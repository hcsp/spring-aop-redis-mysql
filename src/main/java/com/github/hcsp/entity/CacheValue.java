package com.github.hcsp.entity;

import java.io.Serializable;
import java.time.Instant;

public class CacheValue implements Serializable {
    private Object value;
    private Instant cacheTime;

    public CacheValue(Object value, Instant cacheTime) {
        this.value = value;
        this.cacheTime = cacheTime;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Instant getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(Instant cacheTime) {
        this.cacheTime = cacheTime;
    }
}
