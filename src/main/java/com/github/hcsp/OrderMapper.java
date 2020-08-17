package com.github.hcsp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select g.name as goods, SUM(o.price * o.quantity) as price from `order` o right join goods g on g.id = o.goods_id GROUP by g.id order by price desc;")
    List<Order> getRank();
}
