package com.github.hcsp.entity;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 13:20
 * @version: 1.0
 * @since: JDK 8
 */
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
