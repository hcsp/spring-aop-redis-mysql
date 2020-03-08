package com.github.hcsp.service;

import com.github.hcsp.Cache;
import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService {
    @Autowired
    private SqlSession sqlSession;

    @Cache
    public List<RankItem> searchRank() {
        return sqlSession.selectList("mapper.selectRank");
    }
}
