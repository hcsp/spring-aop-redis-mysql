package com.github.hcsp.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private int id;
    private String name;

}
