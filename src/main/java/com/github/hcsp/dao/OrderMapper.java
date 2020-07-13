package com.github.hcsp.dao;

import com.github.hcsp.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from user where id = #{id}")
    Order getUserById(@Param("id") Integer id);
}
