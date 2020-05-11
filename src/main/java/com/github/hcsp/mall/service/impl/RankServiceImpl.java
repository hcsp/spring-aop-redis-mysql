package com.github.hcsp.mall.service.impl;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.mall.dao.RankDao;
import com.github.hcsp.mall.entity.RankItem;
import com.github.hcsp.mall.service.RankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    private final RankDao rankDao;

    public RankServiceImpl(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Override
    @Cache
    public List<RankItem> getRankItems() {
        return rankDao.getRankItems();
    }
}
