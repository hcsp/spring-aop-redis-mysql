package com.github.hcsp.services;

import com.github.hcsp.annotations.Cache;
import com.github.hcsp.dao.RankOrderDao;
import com.github.hcsp.entities.RankItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RankOrderService {
    @Resource
    RankOrderDao rankOrderDao;

    @Cache
    public List<RankItem> doService() {
        return rankOrderDao.doRankOrder();
    }
}
