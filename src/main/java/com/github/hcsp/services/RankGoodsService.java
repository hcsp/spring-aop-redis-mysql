package com.github.hcsp.services;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankGoodsDao;
import com.github.hcsp.entity.GoodsSaleRankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankGoodsService {
    @Autowired
    RankGoodsDao rankGoodsDao;

    @Cache
    public List<GoodsSaleRankItem> doService() {
        return rankGoodsDao.doRankGoods();
    }
}
