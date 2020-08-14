/**
 *
 */
package com.github.hcsp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author sunp
 *
 */
@Mapper
@Repository
public interface ItemRankMapper {

    @Select("select goods.name as itemName, sum(`order`.price*`order`.quantity) as totalAmount\r\n" +
            "from `order` right join goods on goods.id = `order`.goods_id\r\n" +
            "group by goods.name order by totalAmount desc;")
    List<ItemRank> queryItemRank();

}
