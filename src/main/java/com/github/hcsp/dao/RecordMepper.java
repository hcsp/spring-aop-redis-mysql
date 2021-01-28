package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodsItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMepper {

    @Select("SELECT\n" +
            "SUM(`order`.price * `order`.quantity) as total,\n" +
            "goods.id as goods_id,\n" +
            "goods.name as goods_name\n" +
            "FROM `order`\n" +
            "LEFT JOIN goods\n" +
            "ON `order`.goods_id = goods.id\n" +
            "GROUP BY `order`.goods_id\n" +
            "ORDER BY total DESC")
    @Results({
        @Result(property = "price", column = "total"),
        @Result(property = "name", column = "goods_name"),
        @Result(property = "id", column = "goods_id")
    })

    List<GoodsItem> queryRecordAll();

}
