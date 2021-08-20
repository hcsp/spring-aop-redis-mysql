package com.github.hcsp.entity;

import java.util.Arrays;
import java.util.Objects;

public class CacheKey {
    private final String name;
    private final Object[] args;
    private final Object caller;

    public CacheKey(String name, Object[] args, Object caller) {
        this.name = name;
        this.args = args;
        this.caller = caller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey cacheKey = (CacheKey) o;
        return Objects.equals(name, cacheKey.name) && Arrays.equals(args, cacheKey.args) && Objects.equals(caller, cacheKey.caller);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, caller);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }
}
