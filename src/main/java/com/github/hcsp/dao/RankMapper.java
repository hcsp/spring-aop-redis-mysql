package com.github.hcsp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Zhaofeng Zhou
 * @date 2021/8/2/002 21:46
 */
@Mapper
public interface RankMapper {

    @Select("SELECT g.name,SUM(o.price) as totalPrice FROM `order` o inner join goods g ON o.goods_id = g.id " +
            "GROUP BY g.id " +
            "ORDER BY totalPrice desc")
    List<Map> getRankList();

}
