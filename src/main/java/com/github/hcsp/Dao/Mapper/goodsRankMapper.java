package com.github.hcsp.Dao.Mapper;

import java.util.List;

import com.github.hcsp.Moudle.RankItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface goodsRankMapper {
    @Select("select id, goods_name, total_price from goods_rank ")
    @Results({
        @Result(column = "id", property = "qualifying"),
        @Result(column = "goods_name", property = "goodsName"),
        @Result(column = "total_price", property = "totalPrice")
    })
    List<RankItem> getGoodsRank();
}
