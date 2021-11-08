package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where id = #{id}")
    Goods getUserById(@Param("id") Integer id);
}
