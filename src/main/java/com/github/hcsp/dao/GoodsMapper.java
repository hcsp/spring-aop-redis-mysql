package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface GoodsMapper {
  @Select("SELECT t1.goods_id as id,t1.total_price as total,t2.`name` as goods_name FROM(SELECT  goods_id as goods_id,SUM(`order`.price*`order`.quantity) as total_price FROM `order` GROUP BY goods_id )t1 JOIN goods t2 ON t1.goods_id=t2.id ORDER BY t1.total_price DESC")
  @Results({
    @Result(property = "totalPrice" ,column = "total"),
    @Result(property = "name",column = "goods_name")
  })
  List<Goods> getAll();
}
