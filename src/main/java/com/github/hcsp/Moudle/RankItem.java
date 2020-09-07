package com.github.hcsp.Moudle;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankItem implements Serializable { //可序列化
    private String goodsName;
    private BigDecimal totalPrice;
}
