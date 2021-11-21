package com.github.hcsp.entity;

import java.io.Serializable;

public class RedisKey implements Serializable {
    private String name;

    public RedisKey(String name) {
        this.name = name;
    }
}
