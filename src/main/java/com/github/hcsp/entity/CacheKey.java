package com.github.hcsp.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class CacheKey implements Serializable {
    static final long serialVersionUID = 42L;
    private String methodName;
    private Object[] args;
    private Object caller;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) o;
        return Objects.equals(methodName, cacheKey.methodName) && Arrays.equals(args, cacheKey.args) && Objects.equals(caller, cacheKey.caller);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(methodName, caller);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }

    public CacheKey(String methodName, Object[] args, Object caller) {
        this.methodName = methodName;
        this.args = args;
        this.caller = caller;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getCaller() {
        return caller;
    }

    public void setCaller(Object caller) {
        this.caller = caller;
    }
}
