package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.entity.GoodsRank;
import com.github.hcsp.mapper.GoodsRankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ruby
 * @date 2021/1/4 0:10
 */
@Service
public class GoodsRankService {
    @Autowired
    private GoodsRankMapper goodsRankMapper;

    @Cache
    public List<GoodsRank> selectGoodsRankList() {
        return goodsRankMapper.selectGoodsRankList();
    }
}
