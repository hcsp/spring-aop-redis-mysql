package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {

    private final RankDao rankDao;

    @Autowired
    public RankService(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Cache(timeout = 1)
    public List<Rank> getGoodsRank() {
        return rankDao.getGoodsRank();
    }
}
