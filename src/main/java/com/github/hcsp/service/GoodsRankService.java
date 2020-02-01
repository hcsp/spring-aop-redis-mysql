package com.github.hcsp.service;

import com.github.hcsp.dao.GoodsRankDAO;
import com.github.hcsp.entity.Goods;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GoodsRankService {
    private GoodsRankDAO goodsRankDAO;

    @Inject
    public GoodsRankService(GoodsRankDAO goodsRankDAO) {
        this.goodsRankDAO = goodsRankDAO;
    }

    public List<Goods> getRankList(){
        return goodsRankDAO.getGoodsAndSortByPrice();
    }
}
