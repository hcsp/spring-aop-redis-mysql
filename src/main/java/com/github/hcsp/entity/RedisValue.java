package com.github.hcsp.entity;

import java.io.Serializable;

public class RedisValue implements Serializable {
    private Object value;
    private long time;

    public RedisValue(Object value, long time) {
        this.value = value;
        this.time = time;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
