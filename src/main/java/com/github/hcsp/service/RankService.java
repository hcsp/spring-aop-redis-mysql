package com.github.hcsp.service;

import com.github.hcsp.annotation.Redis;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.Rank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private final RankDao dao;

    public RankService(RankDao dao) {
        this.dao = dao;
    }

    @Redis
    public List<Rank> getRank() {
        return dao.selectRank();
    }
}
