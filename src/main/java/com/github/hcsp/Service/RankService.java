package com.github.hcsp.Service;

import com.github.hcsp.Dao.CommoditySalesRankingDao;
import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.RankingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private CommoditySalesRankingDao commoditySalesRankingDao;

    @Autowired
    public RankService(CommoditySalesRankingDao commoditySalesRankingDao) {
        this.commoditySalesRankingDao = commoditySalesRankingDao;
    }

    @Cache
    public List<RankingList> SortTheAmountOfGoodsSold() {
        return commoditySalesRankingDao.SortTheAmountOfGoodsSold();
    }

    ;
}
