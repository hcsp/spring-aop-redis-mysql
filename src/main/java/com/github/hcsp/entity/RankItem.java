package com.github.hcsp.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class RankItem implements Serializable {
    private int sum;
    private Goods goods;
}
