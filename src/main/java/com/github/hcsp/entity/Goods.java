package com.github.hcsp.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Goods implements Serializable {
    Integer goods_id;
    String name;
}
