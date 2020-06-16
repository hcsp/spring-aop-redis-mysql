package com.github.hcsp.service;

import com.github.hcsp.dao.MallDao;
import com.github.hcsp.entity.GoodRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService {

    private MallDao mallDao;

    @Autowired
    public MallService(MallDao mallDao) {
        this.mallDao = mallDao;
    }

    public List<GoodRank> getGoodAmountRank() {
        return mallDao.getGoodAmountRank();
    }
}
