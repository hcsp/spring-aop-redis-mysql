package com.github.hcsp.DAO;

import com.github.hcsp.entity.GoodsDealInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

    @Select("select r.name, COALESCE(r.totalDeal, 0)\n" +
            "from (SELECT g.NAME,\n" +
            "             SUM(o.sum) totalDeal\n" +
            "      FROM (SELECT o.goods_id, (o.price * o.quantity) sum FROM `order` o) o\n" +
            "               right JOIN goods g ON g.id = o.goods_id\n" +
            "      GROUP BY g.name\n" +
            "      ORDER BY totalDeal DESC) r;")
    List<GoodsDealInfo> getDealRank();
}
