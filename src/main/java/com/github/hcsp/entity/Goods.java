package com.github.hcsp.entity;

import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: Goods
 * @Description:
 * @date 2020-08-30
 */
public class Goods implements Serializable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
