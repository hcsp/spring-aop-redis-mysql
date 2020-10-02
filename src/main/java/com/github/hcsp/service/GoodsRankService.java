package com.github.hcsp.service;


import com.github.hcsp.dao.GoodsRankDao;
import com.github.hcsp.entity.GoodsRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsRankService {

    @Autowired
    private GoodsRankDao rankDao;

    public List<GoodsRank> getRank() {
        return rankDao.getGoodsRank();
    }
}
