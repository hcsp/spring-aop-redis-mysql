package com.github.hcsp.dao;


import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public RankItem getUserById(@Param("id")Integer id);
}

