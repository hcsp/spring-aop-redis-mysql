package com.github.hcsp.service;

import com.github.hcsp.annotation.MyCache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RankService {
    @Inject
    private RankDao rankDao;

    @MyCache(durationSeconds = 2)
    public List<RankItem> getRank() {
        return rankDao.getRank();
    }
}
