package com.github.hcsp.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
public class Item implements Serializable {
    Goods goods;
    BigDecimal amount;
}
