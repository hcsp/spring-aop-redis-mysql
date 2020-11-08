package com.github.hcsp;

import java.io.Serializable;

public class CacheItem implements Serializable {
    private long time;
    private Object cacheValue;

    public CacheItem(long time, Object cacheValue) {
        this.time = time;
        this.cacheValue = cacheValue;
    }

    public long getTime() {
        return time;
    }

    public Object getCacheValue() {
        return cacheValue;
    }
}
