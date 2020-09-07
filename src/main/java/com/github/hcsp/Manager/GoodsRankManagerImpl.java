package com.github.hcsp.Manager;

import java.util.List;

import com.github.hcsp.Dao.goodsRankDao;
import com.github.hcsp.Moudle.RankItem;
import com.github.hcsp.anno.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsRankManagerImpl implements goodsRankManager {
    private final goodsRankDao goodsRankDao;

    @Autowired
    public GoodsRankManagerImpl(com.github.hcsp.Dao.goodsRankDao goodsRankDao) {
        this.goodsRankDao = goodsRankDao;
    }

    @Cache
    @Override
    public List<RankItem> getGoodsRank() {
        return goodsRankDao.getGoodsRank();
    }
}
