package com.github.hcsp.Dao;

import com.github.hcsp.entity.RankingList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface RankMapper {
    @Select("select goods.name as goodsName, sum(`order`.price*`order`.quantity) as Turnover from goods\n" +
            "left join `order`\n" +
            "on `order`.goods_id=goods.id\n" +
            "group by goods.id\n" +
            "order by Turnover desc")
    List<RankingList> SortTheAmountOfGoodsSold();
}
