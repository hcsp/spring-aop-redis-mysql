package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {

    private RankDao rankDao;

    public RankService(@Autowired RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Cache
    public List<RankItem> getRankItems() {
        return rankDao.getRankItems();
    }
}
