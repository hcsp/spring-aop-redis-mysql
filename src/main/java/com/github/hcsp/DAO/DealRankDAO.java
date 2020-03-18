package com.github.hcsp.DAO;

import com.github.hcsp.entity.GoodsDealInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 12:18
 */
@Mapper
public interface DealRankDAO {
    @Results(@Result(property = "dealPrice", column = "totalDeal"))

    @Select("SELECT\n" +
            "\tg.NAME,\n" +
            "\tSUM(o.sum) totalDeal\n" +
            "FROM\n" +
            "\t( SELECT o.goods_id, (o.price* o.quantity) sum FROM `order` o ) o\n" +
            "\tINNER JOIN goods g ON g.id = o.goods_id\n" +
            "\tGROUP BY g.name\n" +
            "\tORDER BY totalDeal DESC")
    List<GoodsDealInfo> getDealRank();
}
