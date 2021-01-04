package com.github.hcsp.entity;

import java.math.BigDecimal;

/**
 * @author Ruby
 * @date 2021/1/3 22:41
 */
public class GoodsRank {
    private String name;
    private BigDecimal total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoodsRank{");
        sb.append("name='").append(name).append('\'');
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
