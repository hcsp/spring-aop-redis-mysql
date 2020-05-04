package com.github.hcsp.dao;

import com.github.hcsp.entity.Rank;
import com.github.hcsp.mapper.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {
    @Autowired
    private RankMapper rankMapper;

    public List<Rank> getRankList() {
        return rankMapper.getRankList();
    }
}
