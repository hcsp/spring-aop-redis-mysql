package com.github.hcsp.service;

import com.github.hcsp.dao.GoodsSalesRankDao;
import com.github.hcsp.entity.GoodsSalesRankItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSalesRankService {
    private final GoodsSalesRankDao goodsSalesRankDao;

    public GoodsSalesRankService(GoodsSalesRankDao goodsSalesRankDao) {
        this.goodsSalesRankDao = goodsSalesRankDao;
    }

    public List<GoodsSalesRankItem> getGoodsSalesRank() {
        return this.goodsSalesRankDao.getGoodsSalesRank();
    }
}
