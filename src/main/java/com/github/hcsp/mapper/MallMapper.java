package com.github.hcsp.mapper;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MallMapper {

    @Select("select g.name,ifnull(s.amount,0) amount \n" +
            "from goods g left join \n" +
            "(select CAST(sum(o.price*o.quantity) AS DECIMAL) amount,o.goods_id gid from `order` o group by o.goods_id) as s \n" +
            "on g.id = s.gid order by amount desc")
    List<Goods> getSortedGoods();

}
