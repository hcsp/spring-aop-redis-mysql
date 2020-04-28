package com.github.hcsp.Dao;

import com.github.hcsp.entity.RankingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditySalesRankingDao {
    private RankMapper rankMapper;

    @Autowired
    public CommoditySalesRankingDao(RankMapper rankMapper) {
        this.rankMapper = rankMapper;
    }

    public List<RankingList> SortTheAmountOfGoodsSold() {
        return rankMapper.SortTheAmountOfGoodsSold();
    }
}
