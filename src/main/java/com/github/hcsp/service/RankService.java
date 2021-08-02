package com.github.hcsp.service;

import com.github.hcsp.dao.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Zhaofeng Zhou
 * @date 2021/8/2/002 22:02
 */
@Service
public class RankService {
    private RankMapper rankMapper;

    @Autowired
    public RankService(RankMapper rankMapper) {
        this.rankMapper = rankMapper;
    }

    public List<Map> getRankList() {
        return rankMapper.getRankList();
    }
}
