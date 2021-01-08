package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface GoodsMapper {
  @Select("SELECT * FROM goods")
  @Results({
    @Result(property = "totalPrice" ,column = "id"),
    @Result(property = "name",column = "name")
  })
  List<Goods> getAll();
}
