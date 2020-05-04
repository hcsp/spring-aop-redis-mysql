package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    @Autowired
    private RankDao rankDao;

    @Cache
    public List<Rank> getRankList() {
        return rankDao.getRankList();
    }
}
