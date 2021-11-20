package com.github.hcsp.service;

import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import org.springframework.stereotype.Service;
import com.github.hcsp.anno.Cache;
import java.util.List;

@Service
public class RankService {
    private final RankDao rankDao;

    public RankService(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Cache
    public List<RankItem> getRank() {
        return rankDao.getRank();
    }
}
