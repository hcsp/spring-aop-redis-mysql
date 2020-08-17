/**
 *
 */
package com.github.hcsp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


/**
 * @author sunp
 *
 */
@Mapper

public interface ItemRankMapper {

    @Select("select goods.name as itemName, sum(`order`.price*`order`.quantity) as totalAmount\r\n"
    + "from `order` right join goods on goods.id = `order`.goods_id\r\n"
    + "group by goods.name order by totalAmount desc;")

    List<ItemRank> queryItemRank();
}
