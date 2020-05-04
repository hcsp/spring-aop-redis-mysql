package com.github.hcsp.mapper;

import com.github.hcsp.entity.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RankMapper {
    @Select("select g.`name`,t.price\n" +
            "FROM (\n" +
            "\tselect goods_id goodsId,sum(price * quantity) as price\n" +
            "from `order`\n" +
            "GROUP BY goods_id\n" +
            ") t JOIN goods g ON t.goodsId = g.id ORDER BY t.price DESC")
    List<Rank> getRankList();
}
