package com.github.hcsp.mapper;

import com.github.hcsp.entity.GoodsRank;

import java.util.List;

/**
 * @author Ruby
 * @date 2021/1/3 22:49
 */
public interface GoodsRankMapper {
    /**
     * 获取商品排行榜
     *
     * @return list
     */
    List<GoodsRank> selectGoodsRankList();
}
